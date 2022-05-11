package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@SpringBootApplication
public class KafkaBeginersProjApplication {

	public static void main(String[] args) {

		// SpringApplication.run(KafkaBeginersProjApplication.class, args);
		String bootStartServers = "localhost:9092";

		// create properties
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStartServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class.getName());

		// create producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		ProducerRecord<String, String> record = new ProducerRecord<String, String>("sampletopic", "Hello sample topic");
		 producer.send(record);
		 producer.flush();
		 
		 producer.close();

	}

}
