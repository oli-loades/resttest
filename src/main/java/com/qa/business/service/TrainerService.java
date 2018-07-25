package com.qa.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qa.Constants.Constants;

@Component
public class TrainerService {
	
	@Autowired 
	private RestTemplate restTemplate;
	
	public String getAllTrainers() {
		return restTemplate.getForObject(Constants.API_ADDRESS,String.class);
	}
}
