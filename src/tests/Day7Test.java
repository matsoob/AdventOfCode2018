package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import solutions.Day7Solution;

public class Day7Test {

	@Test
	public void test() {
		ArrayList<String> inputs = new ArrayList<>();
		inputs.add("Step C must be finished before step A can begin.");
		inputs.add("Step C must be finished before step F can begin.");
		inputs.add("Step A must be finished before step B can begin.");
		inputs.add("Step A must be finished before step D can begin.");
		inputs.add("Step B must be finished before step E can begin.");
		inputs.add("Step D must be finished before step E can begin.");
		inputs.add("Step F must be finished before step E can begin.");
		Day7Solution sol = new Day7Solution(inputs);
		assertEquals("CABDFE", sol.getOrder());
		assertEquals(15, sol.getTime(0, 2));
	}

}
