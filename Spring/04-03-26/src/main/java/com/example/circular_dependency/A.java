package com.example.circular_dependency;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;

public class A {
    public B b;
//    public A(B b){
//        this.b=b;
//    }
    @PreDestroy
    public void preDestroy(){
    System.out.println("This is A PreDestroy implemented");
}
    @PostConstruct
    public void postConstruct(){
        System.out.println("This is A PostConstruct implemented");
    }
    @Autowired
    public void B_setter(B b){
        this.b=b;
        System.out.println("B initialised in class A");
    }
}
