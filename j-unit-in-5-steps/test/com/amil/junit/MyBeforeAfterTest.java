package com.amil.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {
	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll ");
	}
	@BeforeEach
	void beforeEach() {
		System.out.println("before each");
	}
	@Test
	void test1() {
		System.out.println("test1");
	}
	@Test
	void test2() {
		System.out.println("test2");
	}
	@Test
	void test3() {
		System.out.println("test3");
	}
	@Test
	void test4() {
		System.out.println("test4");
	}
	@Test
	void test5() {
		System.out.println("test5");
	}
	@AfterEach
	void afterEach() {
		System.out.println("after each");
	}
	@AfterAll
	static void afterAll() {
		System.out.println("afterAll ");
	}

}
