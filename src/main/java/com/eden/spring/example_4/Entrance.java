package com.eden.spring.example_4;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Entrance {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("d:\\config.xml");
        FirstBean bean = context.getBean(FirstBean.class);
        bean.printMsg();
        context.close();
    }
}
