package service;

import java.util.List;

import com.formation.entities.User;
import com.formation.entities.UserDto;

public interface UserService {
	 User save(UserDto user);
	    List<User> findAll();
	    void delete(long code);
	    User findOne(String Login);

	    User findBycode(Long code);
	    User findById(Long id);

		
}
