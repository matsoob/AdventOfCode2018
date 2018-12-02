package solutions;

import java.util.ArrayList;
import java.util.HashMap;

public class Day2Solution {
	private ArrayList<String> inputs;
	
	public Day2Solution(ArrayList<String> inputs){
		this.inputs = inputs;
	}
	
	public int getCheckSum(){
		int twice = 0;
		int thrice = 0;
		for (String input : inputs){
			Pair result = checkLine(input);
			if (result.twice > 0) {
				twice++;
			}
			if (result.thrice > 0) {
				thrice++;
			}
		}
		return twice*thrice;
		
	}
	
	public String getPair(){
		// construct Trie
		int lengthOfIds = inputs.get(0).length();
		for (int i=0; i<lengthOfIds; i++){
			TrieNode root = new TrieNode("");
			for (String s : inputs){
				String temp = s.substring(0, i) + s.substring(i+1);
				boolean wasSecond = root.addAndDetectDupes(temp);
				if (wasSecond){
					return temp;
				}
			}	
		}
		return "";

		
	}
	
	private Pair checkLine(String str){
		int[] occurances = new int[26];
		int twice = 0;
		int thrice = 0;
		for (int i=0; i<str.length(); i++){
			occurances[(str.charAt(i) - 'a')]++;
			if (occurances[(str.charAt(i) - 'a')] == 2){
				twice++;
			} else if (occurances[(str.charAt(i) - 'a')] == 3){
				twice--;
				thrice++;
			} else if (occurances[(str.charAt(i) - 'a')] == 4){
				thrice--;
			}
		}
		return new Pair(twice, thrice);
	}

}

class Pair {
	int twice;
	int thrice;
	public Pair(int twice, int thrice){
		this.twice = twice;
		this.thrice = thrice;
	}
}

class TrieNode {
	
	HashMap<Character, TrieNode> map;
	int terminating;
	
	public TrieNode(String str){
		this.map = new HashMap<>();
		if (str.length() > 0){
			map.put(str.charAt(0), new TrieNode(str.substring(1)));
		} else if (str.length() == 0) {
			this.terminating++;
		}
	}
	
	public boolean addAndDetectDupes(String str){
		if (str.length() > 0 ){
			if (map.containsKey(str.charAt(0))){
				return map.get(str.charAt(0)).addAndDetectDupes(str.substring(1));
			} else {
				map.put(str.charAt(0), new TrieNode(str.substring(1)));
				return false;
			}
		} else {
			terminating++;
			if (terminating == 2) {
				return true;
			} else {
				return false;
			}
		}
	}
}
