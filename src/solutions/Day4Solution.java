package solutions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day4Solution {
	
	public List<Record> listOfRecords;
	int[][] awake;
	HashMap<Integer, int[]> sleepPattern;
	HashMap<Integer, Integer> sleepTime;
	
	public Day4Solution(List<String> inputs){
		this.sleepPattern = new HashMap<Integer, int[]>();
		this.sleepTime = new HashMap<Integer,Integer>();
		listOfRecords = inputs.stream()
					.map(input -> new Record(input))
					.sorted()
					.collect(Collectors.toList());
	}
	
	public int getSleepiest(){
		int currentId = 0;
		LocalDateTime ldt = null;
		for (Record r : listOfRecords){
			if (r.content.substring(0, 5).equals("Guard")){
				currentId = Integer.parseInt(r.content.split("\\s")[1].substring(1));
				System.out.println("Guard " + currentId + " started shift");
				ldt = null;
			} else {
				if (ldt == null){
					ldt = r.ldt;
				} else {
					int sleepMinute = ldt.getMinute();
					int wakeMinute = r.ldt.getMinute();
					System.out.println("was asleep " + (wakeMinute - sleepMinute));

					if (sleepTime.containsKey(currentId)){
						sleepTime.put(currentId, 
								sleepTime.get(currentId) + wakeMinute - sleepMinute);
					} else {
						sleepTime.put(currentId, wakeMinute - sleepMinute);
					}
					
					if (sleepPattern.containsKey(currentId)){
						//int[] sleep = 
						for (int i=sleepMinute; i<wakeMinute; i++) {
							sleepPattern.get(currentId)[i]++;
						}
						//sleepPattern.put(currentId, sleep);
						
					} else {
						int[] sleep = new int[60];
						for (int i=sleepMinute; i<wakeMinute; i++) {
							sleep[i]++;
						}
						sleepPattern.put(currentId, sleep);
						
					}
					ldt = null;
				}
			}
		}
		int sleepiest = 0;
		int sleepDuration = 0;
		for (Integer id: sleepTime.keySet()) {
			System.out.println("Elf is " + id);
			System.out.println("Sleep duration is " + sleepTime.get(id));
			if (sleepTime.get(id) > sleepDuration){
				sleepDuration = sleepTime.get(id);
				sleepiest = id;
			}
		}
		System.out.println("Sleepiest is " + sleepiest);
		System.out.println("Total minutes is " + sleepDuration);
		
		int[] sleepiestPattern = sleepPattern.get(sleepiest);
		
		int sleepiestMinute = -1;
		int howManyTimes = 0;
		for (int i=0; i< sleepiestPattern.length; i++){
			System.out.print(sleepiestPattern[i] + ", ");
			if (sleepiestPattern[i] > howManyTimes){
				sleepiestMinute = i;
				howManyTimes = sleepiestPattern[i];
			}
		}
		
		//System.out.println("Sleepiest minute for them is: " + sleepiestMinute);
		//System.out.println("Was asleep: " + howManyTimes);
		//System.out.println(sleepiestMinute*sleepiest);
		return sleepiestMinute*sleepiest;
		
	}
	
	public int getMostFrequent(){
		int maxSleeper = -1;
		int maxTimesAsleep = -1;
		int maxMinute = -1;
		for (Integer i : sleepPattern.keySet()){
			int[] pattern = sleepPattern.get(i);
			for (int j=0; j<60; j++){
				if (pattern[j] > maxTimesAsleep){
					maxSleeper = i;
					maxTimesAsleep = pattern[j];
					maxMinute = j;
				}
			}
		}
		return maxSleeper * maxMinute;
		
	}
}


