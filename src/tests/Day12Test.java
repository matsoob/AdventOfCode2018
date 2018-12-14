package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import solutions.Day12Solution;

public class Day12Test {
	
	@Test
	public void test(){
		String test = "#..#.#..##......###...###";
		String[] arr = {"...## => #",
				"..#.. => #",
				".#... => #",
				".#.#. => #",
				".#.## => #",
				".##.. => #",
				".#### => #",
				"#.#.# => #",
				"#.### => #",
				"##.#. => #",
				"##.## => #",
				"###.. => #",
				"###.# => #",
				"####. => #"};
		ArrayList<String> ls = new ArrayList<String>(Arrays.asList(arr));
		Day12Solution sol = new Day12Solution(test, ls);
		assertEquals(19, sol.runTimes(20));
		assertEquals(325, sol.count());
	}
}
