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
	
	@Test
	public void testSubstring(){
		String str = "ivyhczwokexltwhsfamqprbnuy";
		String temp = str.substring(0,0) + str.substring(1);
		assertEquals("vyhczwokexltwhsfamqprbnuy", temp);
	}
	
	@Test
	public void test() {
		ArrayList<String> testcase = new ArrayList<String>();
		testcase.add("abcde"); 	
		testcase.add("fghij"); 
		testcase.add("klmno"); 
		testcase.add("pqrst"); 
		testcase.add("fguij"); 
		testcase.add("axcye"); 
		testcase.add("wvxyz"); 
		Day2Solution sol = new Day2Solution(testcase);
		String str = sol.getPair();
		assertEquals("fgij", str);
	}

}
