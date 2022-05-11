package com.kafka.serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PayloadSerializer implements org.apache.kafka.common.serialization.Serializer {

	@Override
	public byte[] serialize(String topic, Object data) {

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(data);
			oos.close();
			byte[] b = baos.toByteArray();
			return b;
		} catch (IOException e) {
			return new byte[0];
		}
	}

}
