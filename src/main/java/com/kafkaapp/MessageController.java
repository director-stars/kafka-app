package com.kafkaapp;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        System.out.println("test");
    }
    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("KafkaApp", request.message());
        System.out.println("test");
    }
}
