package io.spring.processorfunc;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
class ProcessorfuncApplicationTests {

	@Autowired
	private Function<String, String> processor;

	@Test
	@SuppressWarnings("unchecked")
	public void myUnitTest() {
		assertEquals("6789", processor.apply("123456789"));
	}


}
