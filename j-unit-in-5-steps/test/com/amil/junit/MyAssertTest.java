package com.amil.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	@Test
	void test() {
		boolean test = true;
		assertEquals(true,test);
//		assertEquals(false,test,"something went wrong");
//		assertArrayEquals(new int[] {1,2}, new int[] {2,2});
//		fail("Not yet implemented");
	}

}
