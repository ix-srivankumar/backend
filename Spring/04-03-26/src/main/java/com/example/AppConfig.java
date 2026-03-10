package com.example;

import com.example.circular_dependency.A;
import com.example.circular_dependency.B;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {
    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }
    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }
    @Bean
    public A a(){
        return new A();
    }
    @Bean
    public B b(){
        return new B();
    }
}
