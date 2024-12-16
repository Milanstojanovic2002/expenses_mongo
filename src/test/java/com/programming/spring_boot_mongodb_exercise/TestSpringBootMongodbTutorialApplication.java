package com.programming.spring_boot_mongodb_exercise;

import org.springframework.boot.SpringApplication;

public class TestSpringBootMongodbTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringBootMongodbTutorialApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
