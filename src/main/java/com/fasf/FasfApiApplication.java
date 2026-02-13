package com.fasf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FasfApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FasfApiApplication.class, args);
	}

}
