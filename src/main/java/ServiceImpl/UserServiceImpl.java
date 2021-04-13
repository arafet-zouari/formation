package ServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.formation.entities.Role;
import com.formation.entities.User;
import com.formation.entities.UserDto;

import Dao.UserDao;
import service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = (User) userDao.findByUserusername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPwd(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			//authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + Role.getNom()));
		});
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long code) {
		userDao.deleteById(code);
	}

	@Override
	public User findOne(String username) {
		return (User) userDao.findByUserusername(username);
	}

	@Override
	public User findBycode(Long code) {
		return (User) userDao.findById(code).get();
	}
	@Override
	public User save(UserDto user) {
	    User newUser = new User();
	    newUser.setLogin(user.getUsername());
	    newUser.setPwd(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
