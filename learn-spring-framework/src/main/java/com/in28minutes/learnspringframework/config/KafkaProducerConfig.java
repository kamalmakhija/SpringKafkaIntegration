package com.in28minutes.learnspringframework.config;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages="com.in28minutes.learnspringframework")
public class KafkaProducerConfig {

	@Value("${acks}")
	private String acks;

	@Value("${retries}")
	private String retries;
	
	@Value("${batch.size}")
	private String batchSize;
	
	@Value("${linger.ms}")
	private String lingerMs;
	
	@Value("${buffer.memory}")
	private String bufferMemory;
	
	@Value("${key.serializer}")
	private String keySerializer;
	
	@Value("${value.serializer}")
	private String valueSerializer;
	

	@Bean
	public ProducerFactory<String, String> producerFactory() {
	    return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean
	public Map<String, Object> producerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
	    props.put("acks", acks);
	    props.put("retries", retries);
	    props.put("batch.size", batchSize);
	    props.put("linger.ms", lingerMs);
	    props.put("buffer.memory", bufferMemory);
	    props.put("key.serializer", keySerializer);
	    props.put("value.serializer",valueSerializer);
	    
	    props.put("security.protocol", "SSL");
        props.put("ssl.keystore.location", "C:/Users/Kamal/ssl-certs/kafka.server.keystore.jks");
        props.put("ssl.keystore.password", "kamalm");
        props.put("ssl.key.password", "kamal");
        props.put("ssl.truststore.location", "C:/Users/Kamal/ssl-certs/kafka.server.truststore.jks");
        props.put("ssl.truststore.password", "kamalm");
	    
	    return props;
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
	    return new KafkaTemplate<String, String>(producerFactory());
	}
	
}
