package com.example;

import com.example.service.GreetingClient;
import com.example.service.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(GreetingService.class);
        context.close();
    }
}