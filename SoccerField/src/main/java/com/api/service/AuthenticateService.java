package com.api.service;

import com.api.entity.User;
import com.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticateService
{
	private final UserRepository userRepository;

	public AuthenticateService(UserRepository userRepository) {this.userRepository = userRepository;}

	public User getUserById(int userId)
	{
		return userRepository.findById(userId)
				.orElse(null);
	}

	public User login(String userName, String password)
	{
		return userRepository.findByUserNameAndPassword(userName, password)
				.orElse(null);
	}

	public User register(String userName, String password, String phone)
	{
		if (userRepository.findByUserName(userName).isPresent())
			return null;
		User user = new User(userName, password, phone);
		userRepository.save(user);
		return user;
	}

	public User changePassword(String userName, String password)
	{
		User user = userRepository.findByUserName(userName).orElse(null);
		if (user != null)
		{
			user.setPassword(password);
			userRepository.save(user);
		}
		return user;
	}

	public User changePhone(String userName, String phone)
	{
		User user = userRepository.findByUserName(userName).orElse(null);
		if (user != null)
		{
			user.setPhone(phone);
			userRepository.save(user);
		}
		return user;
	}

	public List<User> getAll()
	{
		return userRepository.findAll();
	}

	public List<User> changeStatus(int userId)
	{
		User user = userRepository.findById(userId).orElse(null);
		if (user != null)
		{
			user.setUserId(userId);
			if (user.getStatus() == 1) {user.setStatus(0);}
			else {user.setStatus(1);}
			userRepository.save(user);
		}
		return userRepository.findAll();
	}
}
