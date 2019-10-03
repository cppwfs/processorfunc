package io.spring.processorfunc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

class ProcessorfuncApplicationTests {

	@Test
	@SuppressWarnings("unchecked")
	public void myUnitTest() {
		ApplicationContext context = SpringApplication.run(ProcessorConfiguration.class);
		Function<String, String> processor = context.getBean("shorten", Function.class);
		assertEquals("6789", processor.apply("123456789"));
	}

}
