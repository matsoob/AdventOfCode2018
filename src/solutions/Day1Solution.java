package solutions;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Day1Solution {
	private long sum;
	private long firstRepeatedFrequency;
	private Queue<Integer> queue;
	private boolean found;
	private LinkedHashSet<Long> freqHistory;
	
	public Day1Solution(){
		this.sum = 0;
		this.freqHistory = new LinkedHashSet<Long>();
		this.queue = new LinkedList<Integer>();
		this.freqHistory.add(0L);
		this.found = false;
	}
	
	public void addString(String numString){
		sum += Integer.valueOf(numString);
		queue.add(Integer.valueOf(numString));
		if (!found){
			if (freqHistory.contains(sum)){
				found = true;
				firstRepeatedFrequency = sum;
			} else {
				freqHistory.add(sum);
			}
		}
	}
	
	public long getSum(){
		return this.sum;
	}
	
	public long getRepeated(){
		long tempSum = sum;	
		while (!found){
			int i = queue.remove();
			tempSum += i;
			if (freqHistory.contains(tempSum)){
				found = true;
				firstRepeatedFrequency = tempSum;
			}
			queue.add(i);
		}
		return firstRepeatedFrequency;
	}
}
