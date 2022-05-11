package com.kafka.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.publisher.service.SendMessage;

@RestController
public class KafkaController {
	
	@Autowired
	SendMessage sendMessage;
	
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		sendMessage.send(message);
	
		return "Message Sent Success";
	}
	

}
