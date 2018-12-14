package solutions;

import java.util.HashMap;

public class TrieNode {
	
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
	
	public boolean contains(String str) {
		if (str.length() > 0 ){
			if (map.containsKey(str.charAt(0))){
				return map.get(str.charAt(0)).contains(str.substring(1));
			} else {
				return false;
			}
		} else {
			if (terminating > 0){
				return true;
			} else {
				return false;
			}
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
	
	public void add(String str){
		if (str.length() > 0 ){
			if (map.containsKey(str.charAt(0))){
				map.get(str.charAt(0)).add(str.substring(1));
			} else {
				map.put(str.charAt(0), new TrieNode(str.substring(1)));
			}
		} else {
			terminating++;
		}
	}
}
