package com.amil.junit;

public class MyMath {
	public int calculateSum(int[] numbers) {
		int sum = 0;
		for(int number:numbers) {
			sum=sum+number;
		}
		return sum;
	}
}
