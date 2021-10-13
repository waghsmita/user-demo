
package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer.Sender;


@RestController

@RequestMapping(value ="/user")
public class KafkaController {
	@Autowired
    private final Sender kafkaProducer =new Sender();

    @PostMapping("/{name}")
    public void sendData(@RequestParam("name") String message) {
    	kafkaProducer.send(message);
        System.out.println("sender"+message);
        //adding for push command 
    }
}
