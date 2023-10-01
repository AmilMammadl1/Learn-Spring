package com.in28minutes.learnspringframework.examples.a6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XMLConfiguratonntextLauncherApplication {


    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            System.out.println(context.getBean("age"));
        }
    }
}
