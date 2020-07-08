package com.mohyehia.kafka.listener;

import com.mohyehia.kafka.entity.User;
import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log
public class Listener {
    @KafkaListener(topics = "SpringKafka", groupId = "group-id")
    public void consume(String message){
        log.info("Consuming from SpringKafka topic");
        log.info("Consumed message =>" + message);
    }

    @KafkaListener(topics = "SpringUserKafka",
            groupId = "user-group",
            containerFactory = "userListenerContainerFactory")
    public void consumeUser(User user){
        log.info("Consuming from SpringUserKafka topic");
        log.info("Consumed user =>" + user);
    }
}
