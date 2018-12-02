package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import solutions.Day2Solution;

public class Day2Test {
	
	@Test
	public void testConstruction(){
		ArrayList<String> testcase = new ArrayList<String>();
		testcase.add("hello");
		testcase.add("world");
		Day2Solution sol = new Day2Solution(testcase);
		assertNotNull(sol);
	}
	
	@Test
	public void testTwice(){
		ArrayList<String> testcase = new ArrayList<String>();
		testcase.add("abcdef");
		testcase.add("bababc");
		testcase.add("abbcde"); 
		testcase.add("abcccd"); 
		testcase.add("aabcdd"); 
		testcase.add("abcdee");
		testcase.add("ababab"); 
		Day2Solution sol = new Day2Solution(testcase);
		assertEquals(12, sol.getCheckSum());
	}

}
