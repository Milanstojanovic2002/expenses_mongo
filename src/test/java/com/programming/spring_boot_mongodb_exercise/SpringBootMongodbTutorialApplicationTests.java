package com.programming.spring_boot_mongodb_exercise;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SpringBootMongodbTutorialApplicationTests {

	@Test
	void contextLoads() {
	}

}
