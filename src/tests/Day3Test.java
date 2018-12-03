package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import solutions.Claim;
import solutions.Day3Solution;

public class Day3Test {

	@Test
	public void testClaim() {
		//Day3Solution sol = new Day3Solution();
		Claim claim = new Claim("#123 @ 3,2: 5x4");
		assertEquals(3, claim.x);
		assertEquals(2, claim.y);
		assertEquals(5, claim.width);
		assertEquals(4, claim.height);
		assertEquals(123, claim.id);
	}
	
	@Test
	public void testClaimOverlap() {
		ArrayList<String> testcase = new ArrayList<String>();
		testcase.add("#1 @ 1,3: 4x4"); 	
		testcase.add("#2 @ 3,1: 4x4"); 
		testcase.add("#3 @ 5,5: 2x2"); 
		Day3Solution sol = new Day3Solution(testcase);
		assertEquals(4, sol.sizeOfClaimed());
		assertEquals(3, sol.getNonOverlapped());
	}

}
