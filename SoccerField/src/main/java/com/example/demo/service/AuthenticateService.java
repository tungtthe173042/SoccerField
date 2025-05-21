package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService
{
	private final UserRepository userRepository;

	public AuthenticateService(UserRepository userRepository) {this.userRepository = userRepository;}

	public boolean login(String userName, String password)
	{
		return userRepository.findByUserName(userName)
				.map(user -> user.getPassword().equals(password))
				.orElse(false);
	}

	public boolean register(String userName, String password, String phone)
	{
		if (userRepository.findByUserName(userName).isPresent())
			return false;
		userRepository.save(new User(userName, password, phone));
		return true;
	}

	public boolean changePassword(String userName, String password)
	{
		return userRepository.findByUserName(userName)
				.map(user -> {
					user.setPassword(password);
					userRepository.save(user);
					return true;
				}).orElse(false);
	}

	public boolean changePhone(String userName, String phone)
	{
		return userRepository.findByUserName(userName)
				.map(user -> {
					user.setPhone(phone);
					userRepository.save(user);
					return true;
				}).orElse(false);
	}
}
