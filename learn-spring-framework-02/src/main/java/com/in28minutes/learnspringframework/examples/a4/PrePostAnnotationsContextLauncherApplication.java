package com.in28minutes.learnspringframework.examples.a4;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SomeClass {
    private SomeDependency someDependency;

    @Autowired
    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
    }

    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("clean up");
    }

}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("test");
    }
}

@Configuration
@ComponentScan()
public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {

        }
    }
}
