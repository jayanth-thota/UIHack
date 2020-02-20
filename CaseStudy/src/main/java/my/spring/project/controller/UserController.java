package my.spring.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.spring.boot.pojos.User;

import my.spring.project.dao.UserRepository;
import my.spring.project.pojos.User;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/getAllusers")
	public Iterable<User>getAllusers()
	{
		return userRepository.findAll();
	}
	@PostMapping("/saveUser")
	 public User saveUser(@RequestBody User user)

	 {

	 System.out.println(user);
	 userRepository.save(user);
	 return user;

	 }
	@PutMapping("/updateUser/{username}")
	public User updateUser(@RequestBody User user,@PathVariable("username") String username)
	 {
			user.setUserName(username);
	 System.out.println(user);
	 userRepository.save(user);
	 return user;
	 }
	@GetMapping("/find/{id}")
	public User find( @PathVariable("id")Integer id)
	{
		
		Optional<User> user=userRepository.findById(id);
		return user.get();
	}
	@DeleteMapping("delete/{id}")
	public boolean delete(@PathVariable("id")Integer id)
	{
		userRepository.deleteById(id);
		return true;
	}

}
