package com.formation.service;

import java.util.List;

import com.formation.entities.User;
import com.formation.entities.UserDto;

public interface UserService {
	    User save(UserDto user);
	    List<User> findAll();
	    void delete(long id);
	    User findOne(String username);
	    User save(User user);
	    User findById(Long id);
	    
		
}
