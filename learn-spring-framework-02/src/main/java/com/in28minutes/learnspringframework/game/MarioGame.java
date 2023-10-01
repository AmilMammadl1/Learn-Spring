package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole{

	public void up() {
		System.out.println("up MarioGame");
	}

	public void down() {
		System.out.println("down MarioGame");
	}

	public void left() {
		System.out.println("left MarioGame");
	}

	public void right() {
		System.out.println("right MarioGame");
	}


}
