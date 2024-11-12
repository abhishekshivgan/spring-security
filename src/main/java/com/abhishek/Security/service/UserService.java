package com.abhishek.Security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.abhishek.Security.model.User;
import com.abhishek.Security.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public User register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));;
		return repo.save(user);
	}
}