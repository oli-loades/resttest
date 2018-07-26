package com.qa.business.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.Constants.Constants;
import com.qa.persistence.domain.Trainer;
import com.qa.persistence.repository.TrainerRepository;
import com.qa.util.JSONUtility;

@Service
public class TrainerService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TrainerRepository trainerRepository;

	public List<Trainer> getAllTrainers() {
		Iterable<Trainer> optionalTrainers = trainerRepository.findAll();
		List<Trainer> allTrainers;
		if (optionalTrainers.iterator().hasNext()) {
			allTrainers = (List<Trainer>) trainerRepository.findAll();
		} else {
			Trainer[] trainers = restTemplate.getForObject(Constants.API_ADDRESS, Trainer[].class);
			allTrainers = Arrays.asList(trainers);
			trainerRepository.saveAll(allTrainers);
		}
		return allTrainers;
	}

	public Trainer getTrainer(int id) {
		Optional<Trainer> optionalTrainer = trainerRepository.findById(id);
		Trainer trainer;
		if (optionalTrainer.isPresent()) {
			trainer = optionalTrainer.get();
		} else {
			trainer = restTemplate.getForObject(Constants.API_ADDRESS2+id, Trainer.class);
		}
		return trainer;
	}
}
