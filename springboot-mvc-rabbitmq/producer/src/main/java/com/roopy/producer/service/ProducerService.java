package com.roopy.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roopy.producer.config.Constants;

@Service
public class ProducerService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sayHello(String name) {
		String message = "Hello, " + name + "!";
		
		rabbitTemplate.convertAndSend(Constants.EXCHANGE_NAME, Constants.QUEUE_NAME, message);
		LOGGER.debug("[x] Sent {} : {}", Constants.QUEUE_NAME, message);
	}
	
}
