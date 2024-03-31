package com.springboot.rendezvousapp;

import com.springboot.rendezvousapp.entities.Role;
import com.springboot.rendezvousapp.entities.User;
import com.springboot.rendezvousapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "com.springboot.rendezvousapp")
public class RendezvousappApplication {
	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(RendezvousappApplication.class, args);
	}

	public void run(String... args){
		List<User> adminAccount = userRepo.findByRole(Role.ADMIN);
		if(adminAccount.isEmpty()){
			User user =new User();

			user.setEmail("admin@gmail.com");
			user.setFirstname("admin");
			user.setLastname("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepo.save(user);

		}


	}
}

