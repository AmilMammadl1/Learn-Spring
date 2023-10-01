package com.in28minutes.learnspringframework.examples.a2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    private ClassA a;

    public ClassB(ClassA a) {
        this.a = a;
        System.out.println(a);
    }
    protected void foo(){
        System.out.println("test");
    }
}


@Configuration
@ComponentScan()
public class LazyInitializationLauncherApplication {


    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
            context.getBean(ClassB.class).foo();

        }
    }
}
