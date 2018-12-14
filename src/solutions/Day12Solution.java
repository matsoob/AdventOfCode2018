package solutions;

import java.util.ArrayList;

public class Day12Solution {
	
	protected char[] pots;
	TrieNode root;

	public Day12Solution(String initialLayout, ArrayList<String> inputs) {
		String[] split = initialLayout.split(":");
		initialLayout = split[1].trim();
		int totalLength = initialLayout.length() + (20*5) + (20*5);
		pots = new char[totalLength];
		int curr = 20*5 - 1;
		for (int i=0; i<totalLength; i++){
			pots[i] = '.';
		}
		for (int i=0; i<initialLayout.length(); i++){
			pots[i + 20*5-1] = initialLayout.charAt(i);
		}
		
		this.root = new TrieNode("");
		for (String s : inputs){
			if (s.charAt(s.length() - 1) == '#'){
				root.addAndDetectDupes(s.substring(0, 5));
			}
		}
	}
	
	public int runTimes(int generations){
		int count = 0;
		for (int i=0; i<generations; i++){
			count = run();
		}
		return count;
	}
	
	public int count(){
		int sum=0;
		for (int i=0; i<pots.length; i++){
			if (pots[i] == '#'){
				sum += (i-20*5+1);
			}
		}
		return sum;
	}
	
	private int run(){
		char[] temp = new char[pots.length];
		int current = 0;
		for (int i=2; i<pots.length-2; i++){
			boolean pop = checkNeighbours(i);
			if (pop){
				current++;
				temp[i] = '#';
			} else {
				temp[i] = '.';
			}
		}
		pots = temp;
		System.out.println("Current count is " + current);
		return current;
	}
	
	private boolean checkNeighbours(int target){
		StringBuilder sb = new StringBuilder();
		for (int i=target-2; i<target+3; i++){
			sb.append(pots[i]);
		}
		String lastPattern = sb.toString();
		return root.contains(lastPattern);
	}

}

