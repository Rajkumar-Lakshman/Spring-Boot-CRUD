package com.bosch.sprint.planner.sprintplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bosch.sprint.planner.sprintplanner")
public class SprintPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintPlannerApplication.class, args);
	}

}
