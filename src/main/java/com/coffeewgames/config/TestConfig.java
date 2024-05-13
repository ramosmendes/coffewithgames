package com.coffeewgames.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.coffeewgames.entities.Computer;
import com.coffeewgames.entities.User;
import com.coffeewgames.entities.enums.TypePc;
import com.coffeewgames.repositories.ComputerRepository;
import com.coffeewgames.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ComputerRepository pcRepository;

	public void run(String... args) throws Exception {

		User u1 = new User("Rivaldo", 18, "jeffjeff@gmail.com", "1548s9z2pw", 150.55);
		User u2 = new User("Jeff", 18, "jeffjeff@gmail.com", "1548s9z2pw", 150.55);

		Computer c1 = new Computer("PC-01", TypePc.LOW);
		Computer c2 = new Computer("PC-02", TypePc.HIGH);
		Computer c3 = new Computer("PC-03", TypePc.ULTRA);
		Computer c4 = new Computer("PC-01", TypePc.MEDIUM);
		
		System.out.println(c4);

		userRepository.saveAll(Arrays.asList(u1, u2));
		pcRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
	}
}
