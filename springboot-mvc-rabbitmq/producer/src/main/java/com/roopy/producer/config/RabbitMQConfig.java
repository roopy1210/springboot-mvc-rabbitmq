package com.roopy.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
    public Queue queue() {
        return new Queue(Constants.QUEUE_NAME, false);
    }
	
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(Constants.EXCHANGE_NAME);
	}

	
	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Constants.QUEUE_NAME);
	}

}
