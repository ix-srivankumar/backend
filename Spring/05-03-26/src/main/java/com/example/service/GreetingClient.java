package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

public class GreetingClient {
    public GreetingService greetingService;
    @Autowired
    public GreetingClient(GreetingService greetingService){
        this.greetingService=greetingService;
        greetingService.greet();
        System.out.println("Executed");
    }
}