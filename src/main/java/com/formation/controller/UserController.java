package com.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.entities.User;
import com.formation.repository.UserRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

public class UserController {


	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	UserRepository userv;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> pro = userv.findAll();

		for (User user : pro) {
			logger.debug("log:     "+user);
			System.out.println("sysout:   "+user);
			
		}
        return pro;
	    
	}
//pour ajouter un utilisateur
	@PostMapping("/addusert")
	public User createUser(@Valid @RequestBody User user) {
	    return userv.save(user);
	}
//recherche d'un utilisateur par son id
	
	@GetMapping("/user/{code}")
	public User getUserById(@PathVariable(value = "code") Long code) {
	    return userv.findById(code).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	//delete user by idcode
	@DeleteMapping("/user/{code}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "code") Long usercode) {
	    User user = userv.findById(usercode).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    userv.delete(user);

	    return ResponseEntity.ok().build();
	}
	//update user
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable(value = "code") Long code,
	                                        @Valid @RequestBody User userDetails) {

	    User user = userv.findById(code).orElseThrow(null);
	    
	   
	    user.setCode(userDetails.getCode());
	    user.setLogin(userDetails.getLogin());
	    user.setPwd(userDetails.getPwd());
	    user.setIdRole(userDetails.getIdRole());

	    User updatedUser = userv.save(user);
	    return updatedUser;
	}
	
	

	/*@PutMapping("/affecter/{uid}/{pid}")
	public void affecterUser(@PathVariable(value = "uid") Long Id,
			@PathVariable(value = "pid") Long Idp,@Valid  Project pro) {

	    
	   List<User> list=new ArrayList<>();
		   User user = userv.findById(Id).get();
		   
		   list.add(user);
		   proj.setUsers(list);
		  //User affecterUser= 
		   pserv.save(proj);
		//return affecterUser;*/
	

	}
	
	
	
	
	
