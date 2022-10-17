package com.reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CreacionHotelesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreacionHotelesApplication.class, args);
	}

}
