package com.in28minutes.learnspringframework.game;

import com.in28minutes.learnspringframework.game.GamingConsole;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {
    public void up() {
        System.out.println("up SuperContraGame");
    }

    public void down() {
        System.out.println("down SuperContraGame");
    }

    public void left() {
        System.out.println("left SuperContraGame");
    }

    public void right() {
        System.out.println("right SuperContraGame");
    }

}
