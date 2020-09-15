package com.learning.restservices.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.learning.restservices.entities.User;
import com.learning.restservices.exceptions.UserAlreadyPresent;
import com.learning.restservices.exceptions.UserNotFound;
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
	public ResponseEntity<Void>  createUser(@RequestBody User user, UriComponentsBuilder builder) {
		try {
		 userService.createUser(user);
		 HttpHeaders header = new HttpHeaders();
		 header.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
		 return new ResponseEntity<Void>(header,HttpStatus.CREATED);
		} catch (UserAlreadyPresent e) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
		
	}
	
	
	//getuserbyID
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserByID(@PathVariable Long id){
		
		
		try {
			return userService.getUserbyID(id);
		} catch (UserNotFound e) {
			
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
			
		}
	}
	
	
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable Long id,@RequestBody User user) {
		
		
		try {
			return userService.updateUserByID(id, user);
		} catch (UserNotFound e) {
			
			
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage())	;
		}
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
