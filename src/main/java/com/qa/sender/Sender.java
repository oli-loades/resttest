package com.qa.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.Application;
import com.qa.Constants.Constants;

@Component
public class Sender {

	@Autowired
	private  RabbitTemplate rabbitTemplate;
	
	public void send(String msg) {
		rabbitTemplate.convertAndSend(Constants.TOPIC_EXCHANGE_NAME, "foo.bar.baz", msg);
	}
}
