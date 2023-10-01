package com.in28minutes.learnspringframework.examples.a0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan()
public class SimpleSpringContextLauncherApplication {

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

        try (var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {

//            context.getBean(GamingConsole.class).up();
//
//            context.getBean(GameRunner.class).run();

        }
    }
}
