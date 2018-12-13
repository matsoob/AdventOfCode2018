package tests;

import java.sql.Array;
import java.util.ArrayList;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import solutions.Day2Solution;

import solutions.Day10Solution;

public class Day10Test {
	
	@Test
	public void test(){
		
		String[] test = {"position=< 9,  1> velocity=< 0,  2>",
				"position=< 7,  0> velocity=<-1,  0>",
				"position=< 3, -2> velocity=<-1,  1>",
				"position=< 6, 10> velocity=<-2, -1>",
				"position=< 2, -4> velocity=< 2,  2>",
				"position=<-6, 10> velocity=< 2, -2>",
				"position=< 1,  8> velocity=< 1, -1>",
				"position=< 1,  7> velocity=< 1,  0>",
				"position=<-3, 11> velocity=< 1, -2>",
				"position=< 7,  6> velocity=<-1, -1>",
				"position=<-2,  3> velocity=< 1,  0>",
				"position=<-4,  3> velocity=< 2,  0>",
				"position=<10, -3> velocity=<-1,  1>",
				"position=< 5, 11> velocity=< 1, -2>",
				"position=< 4,  7> velocity=< 0, -1>",
				"position=< 8, -2> velocity=< 0,  1>",
				"position=<15,  0> velocity=<-2,  0>",
				"position=< 1,  6> velocity=< 1,  0>",
				"position=< 8,  9> velocity=< 0, -1>",
				"position=< 3,  3> velocity=<-1,  1>",
				"position=< 0,  5> velocity=< 0, -1>",
				"position=<-2,  2> velocity=< 2,  0>",
				"position=< 5, -2> velocity=< 1,  2>",
				"position=< 1,  4> velocity=< 2,  1>",
				"position=<-2,  7> velocity=< 2, -2>",
				"position=< 3,  6> velocity=<-1, -1>",
				"position=< 5,  0> velocity=< 1,  0>",
				"position=<-6,  0> velocity=< 2,  0>",
				"position=< 5,  9> velocity=< 1, -2>",
				"position=<14,  7> velocity=<-2,  0>",
				"position=<-3,  6> velocity=< 2, -1>"};
		ArrayList<String> testArray = new ArrayList<String>();
		
		for (String s : test){
			testArray.add(s);
		}
		
		Day10Solution sol = new Day10Solution(testArray);
		assertEquals(31, sol.size());
		
		assertEquals(15, sol.xMax);
		assertEquals(-6, sol.xMin);
		assertEquals(11, sol.yMax);
		assertEquals(-4, sol.yMin);
		
		
	}
}
