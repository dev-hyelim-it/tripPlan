package com.teamProject.tripPlan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TripPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripPlanApplication.class, args);
	}

}