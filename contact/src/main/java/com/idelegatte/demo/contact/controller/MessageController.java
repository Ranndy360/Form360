package com.idelegatte.demo.contact.controller;

import com.idelegatte.demo.contact.config.BaseRestController;
import com.idelegatte.demo.contact.entity.Message;
import com.idelegatte.demo.contact.entity.SenderMessage;
import com.idelegatte.demo.contact.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController extends BaseRestController {
    @Autowired
    private MessageService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SenderMessage> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<SenderMessage> save(@RequestBody Message message) {
        SenderMessage savedCustomer = service.save(message);
        return ResponseEntity.ok(savedCustomer);
    }

}
