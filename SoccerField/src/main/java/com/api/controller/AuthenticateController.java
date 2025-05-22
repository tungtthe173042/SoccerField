package com.api.controller;

import com.api.entity.User;
import com.api.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticateController
{
	@Autowired
	private AuthenticateService authenticateService;

	@PostMapping("/login")
	public User login(@RequestParam String userName, @RequestParam String password)
	{
		return authenticateService.login(userName, password);
	}

	@PostMapping("/register")
	public User register(@RequestParam String userName, @RequestParam String password, @RequestParam String phone)
	{
		return authenticateService.register(userName, password, phone);
	}

	@PatchMapping("/changePhone")
	public User changePhone(@RequestParam String userName, @RequestParam String phone)
	{
		return authenticateService.changePhone(userName, phone);
	}

	@PatchMapping("/changePassword")
	public User changePassword(@RequestParam String userName, @RequestParam String password)
	{
		return authenticateService.changePassword(userName, password);
	}
}
