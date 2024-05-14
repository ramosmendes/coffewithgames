package com.coffeewgames.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.coffeewgames.entities.Computer;
import com.coffeewgames.entities.Rent;
import com.coffeewgames.entities.User;
import com.coffeewgames.entities.enums.RentStatus;
import com.coffeewgames.entities.enums.TypePc;
import com.coffeewgames.repositories.ComputerRepository;
import com.coffeewgames.repositories.RentRepository;
import com.coffeewgames.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ComputerRepository pcRepository;

	@Autowired
	private RentRepository rentRepository;

	public void run(String... args) throws Exception {

		User u1 = new User("Rivaldo", 18, "jeffjeff@gmail.com", "1548s9z2pw", 150.55);
		User u2 = new User("Jeff", 18, "jeffjeff@gmail.com", "1548s9z2pw", 150.55);

		Computer c1 = new Computer("PC-01", TypePc.LOW);
		Computer c2 = new Computer("PC-02", TypePc.HIGH);
		Computer c3 = new Computer("PC-03", TypePc.ULTRA);
		Computer c4 = new Computer("PC-01", TypePc.MEDIUM);

		Rent r1 = new Rent(Instant.now(), RentStatus.PENDING, u1, c1);
		Rent r2 = new Rent(Instant.now(), RentStatus.PAID, u1, c2);
		Rent r3 = new Rent(Instant.parse("2020-04-20T16:53:07Z"), RentStatus.PAID, u2, c3);

		userRepository.saveAll(Arrays.asList(u1, u2));
		pcRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		rentRepository.saveAll(Arrays.asList(r1, r2, r3));
	}
}
