package com.org.myapp.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Test {

    @GetMapping
    public ResponseEntity test(){
        return ResponseEntity.ok("this worked A");
    }
}
