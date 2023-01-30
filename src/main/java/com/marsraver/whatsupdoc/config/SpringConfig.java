package com.marsraver.whatsupdoc.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.ZonedDateTime;

@Slf4j
@EnableKafka
@EnableScheduling
@Configuration
@AllArgsConstructor
public class SpringConfig {

    private MessageService messageService;

    @Scheduled(fixedDelay = 5000)
    public void scheduleFixedDelayTask() {
        String message = "At the tone, the time will be " + ZonedDateTime.now() + ". Beeeep!";
        log.info("Sending a message: " + message);
        messageService.sendMessageNow(message);
    }
}
