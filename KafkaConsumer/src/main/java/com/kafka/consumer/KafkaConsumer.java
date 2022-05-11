package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka.constants.Constants;
import com.kafka.repo.ProductRepository;

@Component
public class KafkaConsumer {
	
	@Autowired
	ProductRepository productRepository;
	


	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(groupId = Constants.GROUP_ID_STRING, topics = Constants.TOPIC_NAME, containerFactory = Constants.KAFKA_LISTENER_CONTAINER_FACTORY)
	public void receivedMessage(Object object) {
		logger.info("New Consumer " + object);
		
		//productDto.map(AppUtils::dtoToEntity).flatMap(productRepository::insert).map(AppUtils::entityToDto);
	}


}
