package com.qa;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.qa.Constants.Constants;
import com.qa.business.service.TrainerService;
import com.qa.sender.Sender;

@SpringBootApplication
public class Application {
	/*
	
	private static final String topicExchangeName = Constants.TOPIC_EXCHANGE_NAME;
	
	private static final String queueName = Constants.QUEUE_NAME;
	
	
	private static final String topicExchangeName = "spring-boot-exchange";

	private static final String queueName = "spring-boot";
*/
	
	@Bean
	Queue queue() {
		return new Queue(Constants.QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(Constants.TOPIC_EXCHANGE_NAME);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	Sender sender() {
		return new Sender();
	}
	
	@Bean
	TrainerService trainerService() {
		return new TrainerService();
	}
	/*
	public static String gettopicExchangeName() {
		return topicExchangeName;
	}
	
	public static String getqueueName() {
		return queueName;
	}
	*/
	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}
	
}
