package com.learning.restservices.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.learning.restservices.repository.UserRepository;

import com.learning.restservices.entities.User;
import com.learning.restservices.exceptions.UserAlreadyPresent;
import com.learning.restservices.exceptions.UserNotFound;

@Service
public class UserService {

	// Autowire the userRepository

	@Autowired
	private UserRepository userRepository;

	// getAllUser

	public List<User> getAllUsers() {

		return userRepository.findAll();

	}

	public User createUser(User user) throws UserAlreadyPresent {
		
		User existingUser=userRepository.findByUsername(user.getUsername());
		
		if(existingUser!=null) {
			throw new UserAlreadyPresent("User Already Present in repo");
		}
	
		return userRepository.save(user);
	}

	public Optional<User> getUserbyID(Long id) throws UserNotFound {

		Optional<User> user = userRepository.findById(id);
if(!user.isPresent()) {
	throw new UserNotFound("User not found in user repo");
}
		return user;
	}

	public User updateUserByID(Long id, User user) throws UserNotFound {

		
		Optional<User> optionaluser = userRepository.findById(id);
		if(!optionaluser.isPresent()) {
			throw new UserNotFound("User not found in user repo");
		}
		user.setId(id);

		
		
		return userRepository.save(user);

	}

	public void deleteUserByID(Long id) {

		Optional<User> optionaluser = userRepository.findById(id);
		if(!optionaluser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"BAD Request");
		}
	

			
			userRepository.deleteById(id);
		

	}
	
	public User getUserByUserName(String username) {
		
		return userRepository.findByUsername(username);
	}

}
