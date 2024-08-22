package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.config.KafkaProducerConfig;
import com.in28minutes.learnspringframework.kafka.SpringKafkaProducer;

public class SpringKafkaMainClass {

	public static void main(String[] args) {

		//1: Launch a Spring Context
		var context = 
			new AnnotationConfigApplicationContext(KafkaProducerConfig.class);
		
		//2: Configure the things that we want Spring to manage - 
		//HelloWorldConfiguration - @Configuration
		//name - @Bean
		
		//3: Retrieving Beans managed by Spring
//		System.out.println(context.getBean("name"));
		
//		System.out.println(context.getBean("age"));
		
//		System.out.println(context.getBean("person"));
		
//		System.out.println(context.getBean("person2MethodCall"));
		
//		System.out.println(context.getBean("person3Parameters"));
		
//		System.out.println(context.getBean("address2"));
		
//		System.out.println(context.getBean("person5Qualifier"));

		System.out.println(context.getBean(SpringKafkaProducer.class));
		context.getBean(SpringKafkaProducer.class).SendMessageToKafkaTopic();
		
		
		
		//System.out.println
//		Arrays.stream(context.getBeanDefinitionNames())
//			.forEach(System.out::println);
		
		
		
	}

}
