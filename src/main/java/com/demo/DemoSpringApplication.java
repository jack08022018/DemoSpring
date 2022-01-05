package com.demo;

import com.demo.dto.ProductDto;
import com.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

	@Autowired
	ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		ProductDto entity = null;
		entity = new ProductDto(32, "Personalized 1", "This is a metal 1", "John Brown 1", "jewelerry");
		productRepository.save(entity);

		entity = new ProductDto(35, "Personalized 2", "This is a metal 2", "John Brown 2", "jewelerry");
		productRepository.save(entity);

		entity = new ProductDto(41, "Personalized 3", "This is a metal 3", "John Brown 3", "jewelerry");
		productRepository.save(entity);
	}
}
