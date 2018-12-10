package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import solutions.Day6Solution;

public class Day6Test {

	@Test
	public void test(){
		ArrayList<String> testCase = new ArrayList<>();
		testCase.add("1, 1");
		testCase.add("1, 6");
		testCase.add("8, 3");
		testCase.add("3, 4");
		testCase.add("5, 5");
		testCase.add("8, 9");
		Day6Solution sol = new Day6Solution(testCase);
		assertEquals(17, sol.getMaxArea());
		assertEquals(16, sol.getSafeArea(32));
	}
}
