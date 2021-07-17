package com.roomcleaning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.SessionAttributes;

@SpringBootApplication
@SessionAttributes("userName")
@EnableJpaRepositories
public class RoomCleaningServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomCleaningServiceApplication.class, args);
	}

}
