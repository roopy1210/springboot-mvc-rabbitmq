package com.roopy.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roopy.consumer.config.Constants;

@SpringBootApplication
public class ConsumerApplication {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	
	@RabbitListener(queues = Constants.QUEUE_NAME)
	public void receiveMessage(String msg) {
		LOGGER.info("[x] Received {}", msg);
	}
}
