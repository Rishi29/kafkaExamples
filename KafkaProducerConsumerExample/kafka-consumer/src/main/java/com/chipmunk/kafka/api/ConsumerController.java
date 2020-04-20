package com.chipmunk.kafka.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

	List<String> message = new ArrayList<>();
	User userFormTopic = null;

	@GetMapping("/consumerStringMessage")
	public List<String> consumeMessage() {
		return message;
	}

	@GetMapping("/consumerJsonMessage")
	public User consumeJsonMessage() {
		return userFormTopic;
	}

	@KafkaListener(groupId = "rishi-1", topics = "hellotopic", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data) {
		message.add(data);
		return message;

	}

	@KafkaListener(groupId = "rishi-2", topics = "hellotopic", containerFactory = "userKafkaListenerContainerFactory")
	public User getMsgFromTopic(User user) {
		userFormTopic = user;
		return userFormTopic;

	}

}
