package com.chipmunk.kafka.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {
	
	@Autowired
	private KafkaTemplate<String, Object>template;
	private String topic ="hellotopic";
	
	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {
		template.send(topic,"Hi "+name+" Welcome to Kafka");
		return "Data published";
	}
	
	@GetMapping("/publishJson")
	public String publishMessage() {
		User user = new User(1,"Rishi", new String[] {"Columbus","1265 waterford Dr","208" });
		template.send(topic, user);
		return "Json Data Published";
		
	}
	
	

}
