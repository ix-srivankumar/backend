package com.example.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class UserRepository {
    public UserRepository(){
        System.out.println("Repository Created");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("This is UserRepo PreDestroy implemented");
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("This is UserRepo PostConstruct implemented");
    }
    public void save(){
        System.out.println("User saved");
    }
}
