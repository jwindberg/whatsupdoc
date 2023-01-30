package com.marsraver.whatsupdoc;

import com.marsraver.whatsupdoc.config.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("kafka")
public class KafkaController {
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody String message) {
        messageService.sendMessageNow(message);
        return ResponseEntity.ok(null);
    }
}
