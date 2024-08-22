package com.in28minutes.learnspringframework.kafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringKafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> producer;

	public KafkaTemplate<String, String> getProducer() {
		return producer;
	}

	public void setProducer(KafkaTemplate<String, String> producer) {
		this.producer = producer;
	}
	
	public void SendMessageToKafkaTopic() {
		String topic = "javainuse-topic";
		String key ="Key1";
		String message = "Hello India";
		producer.send(topic,key,message);
		System.err.println("Message Send. Please check in consumer");
		producer.flush();
	}
	
	
}
