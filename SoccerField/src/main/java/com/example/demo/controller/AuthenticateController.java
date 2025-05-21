package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticateController
{
	@Autowired
	private AuthenticateService authenticateService;

	@PostMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String password)
	{
		if(authenticateService.login(userName, password))
			return userName;
		else
			return "Login failed";
	}

	@PostMapping("/register")
	public String register(@RequestParam String userName, @RequestParam String password, @RequestParam String phone)
	{
		if(authenticateService.register(userName, password, phone))
			return userName;
		else
			return "Registration failed";
	}

	@PostMapping("/changePhone")
	public boolean changePhone(@RequestParam String userName, @RequestParam String phone)
	{
		return authenticateService.changePhone(userName, phone);
	}

	@PostMapping("/changePassword")
	public boolean changePassword(@RequestParam String userName, @RequestParam String password)
	{
		return authenticateService.changePassword(userName, password);
	}
}
