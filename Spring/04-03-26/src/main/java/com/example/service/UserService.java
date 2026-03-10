package com.example.service;

import com.example.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;

public class UserService implements InitializingBean, DisposableBean{
    public UserRepository userRepository;
    public UserService(UserRepository userRepository){
        System.out.println("1.Bean Instantination");
        this.userRepository=userRepository;
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("3.PostConstruct implemented");
    }
    @Override
    public void afterPropertiesSet(){
        System.out.println("4.Initializing bean");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("6.PreDestroy implemented");
    }
    @Override
    public void destroy(){
        System.out.println("7.Disposable bean");
    }
    public void process(){
        System.out.println("5.Bean ready to use");
        userRepository.save();
    }
}
