package com.example;

import com.example.service.UserService;
import com.example.circular_dependency.A;
import com.example.circular_dependency.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        UserService service= context.getBean(UserService.class);
        service.process();
//        A a=context.getBean(A.class);
//        B b=context.getBean(B.class);
//        a.B_setter(b);
//        b.A_Setter(a);
        context.close();
    }
}
