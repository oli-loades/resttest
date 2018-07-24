package com.qa.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.Application;
import com.qa.Constants.Constants;

@RestController
public class Controller {
	
	@Autowired
	private  RabbitTemplate rabbitTemplate;

	@RequestMapping("/")
	@ResponseBody
	public String test() {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(Constants.API_ADDRESS,String.class);
		rabbitTemplate.convertAndSend(Application.gettopicExchangeName(), "foo.bar.baz", result);
		return result;
	}
}
