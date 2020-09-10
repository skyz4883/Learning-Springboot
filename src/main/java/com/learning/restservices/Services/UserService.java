package com.learning.restservices.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.restservices.repository.UserRepository;

import com.learning.restservices.entities.User;

@Service
public class UserService {

	// Autowire the userRepository

	@Autowired
	private UserRepository userRepository;

	// getAllUser

	public List<User> getAllUsers() {

		return userRepository.findAll();

	}

	public User createUser(User user) {

		return userRepository.save(user);
	}

	public Optional<User> getUserbyID(Long id) {

		Optional<User> user = userRepository.findById(id);

		return user;
	}

	public User updateUserByID(Long id, User user) {

		user.setId(id);

		return userRepository.save(user);

	}

	public void deleteUserByID(Long id) {

		if (userRepository.findById(id).isPresent()) {

			userRepository.deleteById(id);
		}

	}
	
	public User getUserByUserName(String username) {
		
		return userRepository.findByUsername(username);
	}

}
