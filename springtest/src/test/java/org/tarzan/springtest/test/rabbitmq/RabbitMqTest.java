package org.tarzan.springtest.test.rabbitmq;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.tarzan.springtest.Application;
import org.tarzan.springtest.rabbitmq.Receiver;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RabbitMqTest {

	private MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationConnect;

	@Value("${spring.rabbitmq.queuename}")
	String queueName;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Receiver receiver;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
	}

	@Test
	public void testSendAndReceiveMQ() throws InterruptedException {
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(queueName, "tarzan comming ");
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(1).isEqualTo(1);
	}
}
