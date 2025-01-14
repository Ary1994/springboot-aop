package com.ary.curso.springboot.app.aop.springbootaop.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ary.curso.springboot.app.aop.springbootaop.services.GreetingService;

@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity <?> greeting(){
        return ResponseEntity.ok(Collections.singletonMap("greeting",greetingService.sayHello("pepe", "Hola q tal como te va ")));

    }

    @GetMapping("/greeting-error")
    public ResponseEntity <?> greetingError(){
        return ResponseEntity.ok(Collections.singletonMap("greeting",greetingService.sayHelloError("pepe", "Hola q tal como te va ")));

    }

   

}
