package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.ProductDto;
import com.kafka.constants.ApplicationConstant;

@RestController
@RequestMapping("/produce")
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@GetMapping("/{message}")
	public String sendMessage(@PathVariable String message) {

		try {
			ProductDto dto  = new ProductDto();
			kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Message sent succuessfully";
	}

}
