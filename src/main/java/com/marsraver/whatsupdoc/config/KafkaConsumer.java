package com.marsraver.whatsupdoc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(topics = "timeCheck", groupId = "foo")
public class KafkaConsumer {

    @KafkaListener(topics = "timeCheck", groupId = "foo")
    public void listenGroupFoo(String message) {
        log.info("Received Message in group foo: " + message);
    }
}
