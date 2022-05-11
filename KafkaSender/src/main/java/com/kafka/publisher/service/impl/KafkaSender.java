package com.kafka.publisher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.publisher.service.SendMessage;

@Service
public class KafkaSender implements SendMessage{

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafka_topic = "kafkaTopic";
	
	@Override
	public void send(String message) {
		
		kafkaTemplate.send(kafka_topic, message);
	}
}
