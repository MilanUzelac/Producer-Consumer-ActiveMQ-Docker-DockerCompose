package com.example.activemqsender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    static String[] messages= {"First","Second","Third"};

    @GetMapping("message/{message}")
    public ResponseEntity<String> publish(@PathVariable("message") final String message){
        for(int i=0;i<messages.length;i++) {
            /*Messages sent to ActivemqReceiverApplication and displayed in console*/
            jmsTemplate.convertAndSend(queue, messages[i] + " message!");
        }
        return new ResponseEntity(message, HttpStatus.OK);
    }

}