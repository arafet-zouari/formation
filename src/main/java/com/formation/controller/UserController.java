package com.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.entities.User;
import com.formation.repository.UserRepository;

import com.formation.controller.UserController;
import com.formation.entities.UserDto;
import com.formation.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

public class UserController {


	private static final Logger logger = LogManager.getLogger(UserController.class);
	  @Autowired
	private UserService userService;
	
	
	 @PreAuthorize("hasRole('ADMIN')")
	    @RequestMapping(value="/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		List<User> pro = userService.findAll();

		for (User user : pro) {
			logger.debug("log:     "+user);
			System.out.println("sysout:   "+user);
			
		}
      return pro;
	    
	}

	@PostMapping("/signup")
	public User createUser(@Valid @RequestBody UserDto user) {
	    return userService.save(user);
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value = "id") Long Id) {
	    return userService.findById(Id);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    User user = userService.findById(userId);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    userService.delete(user.getId());

	    return ResponseEntity.ok().build();
	}
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody User userDetails) {

	    User user =userService.findById(Id);
	    
	    user.setEmail(userDetails.getEmail());
	    user.setPassword(userDetails.getPassword());
	    user.setFname(userDetails.getFname());
	    user.setLname(userDetails.getLname());
	    user.setImageuser(userDetails.getImageuser());
	    
	    User updatedUser = userService.save(user);
	    return updatedUser;
	}
	
	
	}
	
	
	
	
	

