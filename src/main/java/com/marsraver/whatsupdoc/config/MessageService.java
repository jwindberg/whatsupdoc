package com.marsraver.whatsupdoc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public MessageService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value(value = "${kafka.topic}")
    private String kafkaTopic;

    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageNow(String msg) {
        kafkaTemplate.send(kafkaTopic, msg);
    }


}
