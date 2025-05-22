package com.api;

import com.api.entity.User;
import com.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitializer implements CommandLineRunner
{

	private final UserRepository userRepository;

	public AdminUserInitializer(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		if (userRepository.findByUserName("admin").isEmpty()) {
			User admin = new User("admin", "admin123", "");
			admin.setRole(2);
			userRepository.save(admin);
			System.out.println("✅ Admin user created");
		} else {
			System.out.println("ℹ️ Admin user already exists");
		}
	}
}
