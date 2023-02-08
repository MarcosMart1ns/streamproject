package com.streamproject.streamproducer.controller;

import com.streamproject.streamproducer.domain.Message;
import com.streamproject.streamproducer.stream.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping(path = "/prod/msg")
    public ResponseEntity<Message> createMessage(@RequestBody Message message){
        messageProducer.send(message.message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
