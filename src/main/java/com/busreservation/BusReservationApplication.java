package com.busreservation;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class BusReservationApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BusReservationApplication.class, args);
		
		
	}

	
}
