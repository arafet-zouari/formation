package Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.entities.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
	User findByUserusername(String username);	

}
