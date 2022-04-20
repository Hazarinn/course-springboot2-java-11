package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User usuario1 =  new User(null ,"Maria Brown" ,"maria@gmail.com", "988888888", "123456");
		User usuario2 =  new User(null ,"Alex Grenn" ,"alex@gmail.com", "977777777777", "123456");		
		
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), usuario1);
		Order o2 = new Order(null, Instant.parse("2019-07-20T03:53:10Z"), usuario2);
		Order o3 = new Order(null, Instant.parse("2019-07-20T15:53:22Z"), usuario1);
		
		
		userRepository.saveAll(Arrays.asList(usuario1, usuario2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	

}
