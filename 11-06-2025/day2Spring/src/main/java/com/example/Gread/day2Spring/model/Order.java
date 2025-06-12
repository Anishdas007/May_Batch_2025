package com.example.Gread.day2Spring.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Lazy
@Component
public class Order {
    String Name;
    long id;

    public Order() {
        System.out.println("hello world order");
    }

}
