package com.highradius.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.highradius.constants.KafkaConstants;

@Service
public class KafkaService {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public String add(String customer) {
		kafkaTemplate.send(KafkaConstants.TOPIC, customer);
		System.out.println("************Msg published to Kafka topic***************");
		return "Customer Records Added To Kafka Queue Successfully";
	}
	
	@KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
	public void listener(String c) {
		System.out.println("***Msg recieved from Kafka Topic ::" + c);
	}
}