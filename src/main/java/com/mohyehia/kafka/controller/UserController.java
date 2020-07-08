package com.mohyehia.kafka.controller;

import com.mohyehia.kafka.entity.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final KafkaTemplate<String, User> kafkaTemplate;
//    private static final String topic = "SpringKafka";
    private static final String userTopic = "SpringUserKafka";

    public UserController(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") String name){
        kafkaTemplate.send(userTopic, new User(name, "Software Engineer", "Egypt"));
        return "Published successfully!";
    }
}
