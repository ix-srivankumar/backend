package com.example.circular_dependency;

import org.springframework.beans.factory.annotation.Autowired;

public class B {
    public A a;
//    public B(A a){
//        this.a=a;
//    }
    @Autowired
    public void A_Setter(A a){
        this.a=a;
        System.out.println("A initialised in class B");
    }
}
