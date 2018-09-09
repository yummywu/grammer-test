package com.eden.spring.example_3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Entrance {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        A a = context.getBean(A.class);
        a.methodOfA();
        context.close();
    }
}
