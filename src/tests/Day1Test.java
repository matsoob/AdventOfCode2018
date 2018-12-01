package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import solutions.Day1Solution;

public class Day1Test {
	@Test
	public void testAddNums() {
		
		ArrayList<String> ls;
		
		String[] testCase1 = {"+1", "-2", "+3", "+1"};
		String[] testCase2 = {"+1", "+1", "+1"};
		String[] testCase3 = {"+1", "+1", "-2"};
		String[] testCase4 = {"-1", "-2", "-3"};
		ls = new ArrayList<String>(Arrays.asList(testCase1));
		Day1Solution sol = new Day1Solution();
		for (String str : testCase1){
			sol.addString(str);
		}
		assertEquals(3, sol.getSum());
		
		ls = new ArrayList<String>(Arrays.asList(testCase2));
		sol = new Day1Solution();
		for (String str : testCase2){
			sol.addString(str);
		}
		assertEquals(3, sol.getSum());
		
		ls = new ArrayList<String>(Arrays.asList(testCase3));
		sol = new Day1Solution();
		for (String str : testCase3){
			sol.addString(str);
		}
		assertEquals(0, sol.getSum());
		
		ls = new ArrayList<String>(Arrays.asList(testCase4));
		sol = new Day1Solution();
		for (String str : testCase4){
			sol.addString(str);
		}
		assertEquals(-6, sol.getSum());
	}
	
	@Test
	public void testFrequency(){
		String[] testCase = {"10", "-15"};
		Day1Solution sol = new Day1Solution();
		for (String str : testCase) {
			sol.addString(str);
		}
		assertEquals(0L, sol.getRepeated());
	}
}
