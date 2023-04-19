package com.viswa.unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	MyMath math = new MyMath();
	@Test
	void ThreeMemberArray() {
		assertEquals(6, math.calcualate(new int[] {1,2,3}));
	}
	
	@Test
	void ZeroLengthArray() {
		assertEquals(1, math.calcualate(new int[] {}), "Error Message");
		assertTrue(true);
		//assertFalse()
		//assertNull()
		//assertNotNull()
		//assertArraysEquals(expectedArray, actualArray)
	}

}
