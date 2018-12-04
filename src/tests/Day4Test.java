package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import solutions.Day4Solution;
import solutions.Record;

public class Day4Test {

	@Test
	public void testGuardRecord() {
		String test1 = "[1518-09-20 00:05] wakes up";
		Record gr = new Record(test1);
		assertEquals(1518, gr.getTimeStamp().getYear());
		assertEquals(9, gr.getTimeStamp().getMonthValue());
		assertEquals(20, gr.getTimeStamp().getDayOfMonth());
		assertEquals("wakes up", gr.getContent());
	}
	
	@Test
	public void test(){
		String[] arr = {"[1518-11-01 00:00] Guard #10 begins shift",
				"[1518-11-01 00:05] falls asleep",
				"[1518-11-01 00:25] wakes up",
				"[1518-11-01 00:30] falls asleep",
				"[1518-11-01 00:55] wakes up",
				"[1518-11-01 23:58] Guard #99 begins shift",
				"[1518-11-02 00:40] falls asleep",
				"[1518-11-02 00:50] wakes up",
				"[1518-11-03 00:05] Guard #10 begins shift",
				"[1518-11-03 00:24] falls asleep",
				"[1518-11-03 00:29] wakes up",
				"[1518-11-04 00:02] Guard #99 begins shift",
				"[1518-11-04 00:36] falls asleep",
				"[1518-11-04 00:46] wakes up",
				"[1518-11-05 00:03] Guard #99 begins shift",
				"[1518-11-05 00:45] falls asleep",
				"[1518-11-05 00:55] wakes up"};
		List<String> test = Arrays.asList(arr);
		Day4Solution sol = new Day4Solution(test);
		assertEquals("Guard #10 begins shift", sol.listOfRecords.get(0).getContent());
		assertEquals(240, sol.getSleepiest());
		assertEquals(4455, sol.getMostFrequent());
	}

}
