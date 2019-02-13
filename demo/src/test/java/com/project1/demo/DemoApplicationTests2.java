package com.project1.demo;

import com.project1.demo.data.entity.User;
import com.project1.demo.data.repository.UserRepository;
import com.project1.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests2 {


	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Before
	public void contextLoads() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateTime = LocalDate.parse("1976-03-14", formatter);

		User newUser = new User("Marcelo", "Coelho", "coelhomarcelo11@gmail.com", "LA", 88, "forward", dateTime, 100, 92, "USA", "From @Test", "12345678");
		User newUser2 = new User("Marcelo2", "Coelho", "coelhomarcelo12@gmail.com", "LA", 88, "forward", dateTime, 100, 92, "USA", "From @Test", "12345678");
		userService.AddUser(newUser);
		userService.AddUser(newUser2);
	}

	@Test
	public void testUser(){
//		Optional<User> user = userRepository.findById("coelhomarcelo11@gmail.com");
		User user = userRepository.findById("coelhomarcelo11@gmail.com").orElse(null);
		assertNotNull(user);
		User user2 = userRepository.findById("coelhomarcelo12@gmail.com").orElse(null);
		assertEquals(user2.getFirstName(),"Marcelo2");


	}

}
