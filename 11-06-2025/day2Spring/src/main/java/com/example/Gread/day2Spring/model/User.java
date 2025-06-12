package com.example.Gread.day2Spring.model;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component
public class User {

    @Autowired
    Order order;


    public User() {
        System.out.println("hello user");
    }

    @PostConstruct
    public void intializer(){
        System.out.println("post Constructor called");
    }

    public void getUser(){
        System.out.println("user from get user");
    }
}
