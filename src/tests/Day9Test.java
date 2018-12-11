package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import solutions.Day9Solution;

public class Day9Test {

	@Test
	public void test() {
		Day9Solution sol = new Day9Solution();
		String testCase0 = "9 players; last marble is worth 25 points";
		assertEquals(32, sol.count(testCase0));
		String testCase1 = "10 players; last marble is worth 1618 points";
		assertEquals(8317, sol.count(testCase1));
		String testCase2 = "13 players; last marble is worth 7999 points";
		assertEquals(146373, sol.count(testCase2));
		String testCase3 = "17 players; last marble is worth 1104 points";
		assertEquals(2764, sol.count(testCase3));
		String testCase4 = "21 players; last marble is worth 6111 points";
		assertEquals(54718, sol.count(testCase4));
		String testCase5 = "30 players; last marble is worth 5807 points";
		assertEquals(37305, sol.count(testCase5));
	}

}
