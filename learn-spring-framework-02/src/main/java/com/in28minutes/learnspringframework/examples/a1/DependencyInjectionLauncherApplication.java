package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class yourBusinessClass {
    Dependency1 dependency1;

//    @Autowired
    public yourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public Dependency1 getDependency1() {
        return dependency1;
    }

    public void setDependency1(Dependency1 dependency1) {
        this.dependency1 = dependency1;
    }

    public Dependency2 getDependency2() {
        return dependency2;
    }

    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }

    Dependency2 dependency2;

    public String toString() {
        return "dependency1: " + dependency1 + " dependency2: " + dependency2 + "amil";
    }

}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan()
public class DependencyInjectionLauncherApplication {

//    @Bean
//    public GamingConsole game() {
//        var game = new MarioGame();
//        return game;
//    }

//    @Bean
//    public GameRunner gameRunner(GamingConsole game) {
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)) {

            System.out.println(context.getBean(yourBusinessClass.class));


//            context.getBean(GamingConsole.class).up();
//
//            context.getBean(GameRunner.class).run();

        }
    }
}
