package com.amil.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	private MyMath math = new MyMath();

	@Test
	void calculateSum_ThreeMemberArray() {
//		fail("Not yet implemented");
		int expectedResult = 6;
		assertEquals(expectedResult, math.calculateSum(new int[] { 1, 2, 3 }));
	}
	@Test
	void calculateSum_ZeroMemberArray() {
//		fail("Not yet implemented");
		int sum = math.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, sum);
	}


}
