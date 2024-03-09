package com.idelegatte.demo.contact.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseRestController {

    public ResponseEntity<?> generateResponseOk(Object object){
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}