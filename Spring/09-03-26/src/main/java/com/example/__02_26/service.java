package com.example.__02_26;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class service {
    @Value("${Message}")
    public String msg;

    @PostConstruct
    public void greet(){
        System.out.println("Message to the world "+msg);
    }
}
