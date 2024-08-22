package com.in28minutes.learnspringframework.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SpringKafkaConsumer {

    @KafkaListener(topics = "javainuse-topic", groupId = "group_id")
    public void consume(String message) {
        System.err.println("Consumed message: " + message);
    }
}
