package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.Constants.Constants;
import com.qa.business.service.TrainerService;
import com.qa.persistence.domain.Trainer;
import com.qa.sender.Sender;
import com.qa.util.JSONUtility;

@RequestMapping("/api")
@RestController
public class Controller {

	@Autowired
	private TrainerService trainerService;

	@Autowired
	private Sender sender;

	@Autowired
	private JSONUtility util;

	@GetMapping("/test")
	@ResponseBody
	public List<Trainer> test() {
		List<Trainer> result = trainerService.getAllTrainers();
		sender.send(util.getJSONForObject(result), "get");
		return result;
	}

	@GetMapping("/test2")
	@ResponseBody
	public Trainer test2() {
		Trainer result = trainerService.getTrainer(1);
		sender.send(util.getJSONForObject(result), "post");
		return result;
	}
}
