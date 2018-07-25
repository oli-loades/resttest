package com.qa.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.Constants.Constants;
import com.qa.business.service.TrainerService;
import com.qa.sender.Sender;

@RequestMapping("/api")
@RestController
public class Controller {
	
	@Autowired 
	private TrainerService trainerService;
	
	@Autowired
	private Sender sender;

	@GetMapping("/test")
	@ResponseBody
	public String test() {	
		String result = trainerService.getAllTrainers();
		sender.send(result);;
		return result;
	}
}
