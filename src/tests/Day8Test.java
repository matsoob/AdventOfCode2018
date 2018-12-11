package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import solutions.Day8Solution;

public class Day8Test {

	@Test
	public void test() {
		String testCase = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";
		Day8Solution sol = new Day8Solution(testCase);
		assertEquals(138, sol.checksum());
		assertEquals(66, sol.fancyChecksum());
	}

}
