package com.learning.restservices.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.learning.restservices.entities.User;
import com.learning.restservices.Services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		
		return userService.getAllUsers();
	}
	
	//greate user method
	//requestbody
	//postmapping
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
		
		
	}
	
	
	//getuserbyID
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserByID(@PathVariable Long id){
		
		
		return userService.getUserbyID(id);
	}
	
	
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable Long id,@RequestBody User user) {
		
		
		return userService.updateUserByID(id, user);
	}
	
	
	@DeleteMapping("/users/{id}")
	public String deleteUserByID(@PathVariable Long id) {
		
		userService.deleteUserByID(id);
		
		return "user with id "+id+" is deleted";
	}
	
	@GetMapping("/users/byusername/{username}")
	public User getUserByUserName(@PathVariable String username) {
		
		return userService.getUserByUserName(username);
	}
	

}
