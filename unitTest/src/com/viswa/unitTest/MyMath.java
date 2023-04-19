package com.viswa.unitTest;

public class MyMath {
	
	public int calcualate(int[] numbers) {
		
		int sum = 0;
		for(int number:numbers) {
			sum += number;
		}
			
		return sum;
		
	}
}
