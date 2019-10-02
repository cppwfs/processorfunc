package io.spring.processorfunc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProcessorfuncApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessorfuncApplication.class, "--spring.cloud.stream.function.definition=shorten");
	}

}
