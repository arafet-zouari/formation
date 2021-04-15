package com.formation.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.entities.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
	 @Query
	    User findByUsername(String username);	

}
