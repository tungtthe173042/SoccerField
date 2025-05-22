package com.api.controller;

import com.api.entity.User;
import com.api.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthenticateController
{
	@Autowired
	private AuthenticateService authenticateService;

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestParam String userName, @RequestParam String password)
	{
		System.out.println("Received login: userName=" + userName + ", password=" + password);
		User user = authenticateService.login(userName, password);
		return user != null
				? ResponseEntity.ok(user)
				: ResponseEntity.status(401).body(null);
	}

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestParam String userName, @RequestParam String password, @RequestParam String phone)
	{
		System.out.println("Sign up login: userName=" + userName + ", password=" + password);
		User user = authenticateService.register(userName, password, phone);
		return user != null
				? ResponseEntity.ok(user)
				: ResponseEntity.status(401).body(null);
	}

	@PatchMapping("/changePhone")
	public ResponseEntity<User> changePhone(@RequestParam String userName, @RequestParam String phone)
	{
		System.out.println("Received login: userName=" + userName + ", phone=" + phone);
		User user = authenticateService.changePhone(userName, phone);
		return user != null
				? ResponseEntity.ok(user)
				: ResponseEntity.status(401).body(null);
	}

	@PostMapping("/changePassword")
	public ResponseEntity<User> changePassword(@RequestParam String userName, @RequestParam String password)
	{
		System.out.println("Received changePassword: userName=" + userName + ", password=" + password);
		User user = authenticateService.changePassword(userName, password);
		return user != null
				? ResponseEntity.ok(user)
				: ResponseEntity.status(401).body(null);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAll()
	{
		System.out.println("Received getAll");
		List<User> users = authenticateService.getAll()
				.stream()
				.filter(user -> user.getRole() != 2)
				.collect(Collectors.toList());
		return users != null
				? ResponseEntity.ok(users)
				: ResponseEntity.status(401).body(null);
	}

	@PostMapping("/status")
	public ResponseEntity<List<User>> status(@RequestParam int userId)
	{
		System.out.println("Received status: userId=" + userId);
		List<User> users = authenticateService.changeStatus(userId)
				.stream()
				.filter(user -> user.getRole() != 2)
				.collect(Collectors.toList());
		return users != null
				? ResponseEntity.ok(users)
				: ResponseEntity.status(401).body(null);
	}
}
