/*
 * Copyright 2017 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.spring.processorfunc;

import org.junit.jupiter.api.Test;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTests {

	@Test
	public void integrationTest() {

		try (ConfigurableApplicationContext context = new SpringApplicationBuilder(
				TestChannelBinderConfiguration.getCompleteConfiguration(
						ProcessorConfiguration.class))
				.web(WebApplicationType.NONE)
				.run("--spring.jmx.enabled=false",
						"--spring.cloud.stream.function.definition=shorten")) {

			InputDestination inputDestination = context.getBean(InputDestination.class);
			OutputDestination outputDestination = context
					.getBean(OutputDestination.class);

			Message<byte[]> inputMessage = MessageBuilder
					.withPayload("123456789".getBytes()).build();
			inputDestination.send(inputMessage);

			Message<byte[]> outputMessage = outputDestination.receive();
			assertEquals("6789".getBytes(), outputMessage.getPayload());

		}
	}
}
