package io.getarrays.userservice;

import io.getarrays.userservice.domain.AppUser;
import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "Jafar Sadik", "jeff", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Jon Doe", "sh", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Jim Carry", "sk", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Salman Shah", "rak", "1234", new ArrayList<>()));

			userService.addRoleToUser("jeff", "ROLE_USER");
			userService.addRoleToUser("jeff", "ROLE_MANAGER");
			userService.addRoleToUser("sh", "ROLE_ADMIN");
			userService.addRoleToUser("sh", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("sh", "ROLE_MANAGER");
			userService.addRoleToUser("sk", "ROLE_MANAGER");
			userService.addRoleToUser("rak", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("rak", "ROLE_USER");
		};
	}

}
