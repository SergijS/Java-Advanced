package com.example.HibernateProject;

import com.example.HibernateProject.repository.UserRepository;
import com.example.HibernateProject.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class HibernateProjectApplication implements CommandLineRunner {
		@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = userRepository.create(new User("Tom", "Midle", 25, "accountant", "tom@gmail.com"));
		User user1 = userRepository.create(new User("Mike", "Foll", 32, "driver", "mike@gmail.com"));
		User user2 = userRepository.create(new User("Alice", "Rode", 18, "assistant manager", "alsce@gmail.com"));
		userRepository.deleteUserById(4L);
		userRepository.updateUser(new User(1L, "Sven", "Archer", 32, "java developer", "sven@gmail.com"));
		userRepository.getAll().stream().forEach(user -> System.out.println(user));
		userRepository.getByEmail("sven@gmail.com").forEach(System.out::println);
		System.out.println(userRepository.getById(2));
	}
}