package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import solutions.Day5Solution;

public class Day5Test {
	
	@Test
	public void testConstruction(){
		Day5Solution sol = new Day5Solution("dabAcCaCBAcCcaDA");
		assertNotNull(sol);
		assertEquals(true, sol.isOpposite('c','C'));
		assertEquals(false, sol.isOpposite('C','C'));
		assertEquals(true, sol.isOpposite('C','c'));
		assertEquals(false, sol.isOpposite('c', 'B'));
		assertEquals('c', sol.getOpposite('C'));
		assertEquals('C', sol.getOpposite('c'));
		assertEquals(10, sol.chompOriginal());
		assertEquals(4, sol.compareShortest());
	}
}
