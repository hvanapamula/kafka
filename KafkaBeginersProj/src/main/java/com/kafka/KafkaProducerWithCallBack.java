package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KafkaProducerWithCallBack {
	public static void main(String[] args) {

		// SpringApplication.run(KafkaBeginersProjApplication.class, args);
		String bootStartServers = "localhost:9092";

		// create properties
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStartServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				org.apache.kafka.common.serialization.StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				org.apache.kafka.common.serialization.StringSerializer.class.getName());

		// create producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		for (int i = 0; i < 10; i++) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("sampletopic",
					"Hello sample topic "+i);
			producer.send(record, new Callback() {

				@Override
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					// Acknowledgement from kafka
					if (exception == null) {
						System.out.println("Received new metadata \n " + "Topic : " + metadata.topic() + "\n Parition "
								+ metadata.partition());
					} else {
						System.out.println("Error Not ");

					}
				}
			});
		}
		producer.flush();

		producer.close();

	}

}
