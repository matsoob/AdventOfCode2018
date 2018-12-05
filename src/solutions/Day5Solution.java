package solutions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Day5Solution {
	
	String original;
	final int alphaConstant = 'a' - 'A';

	public Day5Solution(String target){
		this.original = target;
	}
	
	public int chompOriginal() {
		
		LinkedList<Character> list = new LinkedList<Character>();
		for (int i=0 ; i < original.length(); i++) {
			list.add(original.charAt(i));
		}
		
		return chomp(list);

	}
	
	private int chomp(LinkedList<Character> list){
		ListIterator<Character> iterator = list.listIterator(0);
		LinkedList<Character> result = new LinkedList<Character>();
		
		while (iterator.hasNext()){
			char curr = iterator.next();
			if (result.isEmpty()){
				result.add(curr);
			} else {
				if (isOpposite(result.peekLast(), curr)){
					result.removeLast();
				} else {
					result.addLast(curr);
				}
			}
		}
		return result.size();
		
	}
	
	public int compareShortest(){
		
		int shortest = Integer.MAX_VALUE;
		for (char alph = 'A'; alph < 'Z'; alph++){
			LinkedList<Character> list = new LinkedList<>();
			for (int i=0 ; i < original.length(); i++) {
				if (original.charAt(i) != alph && original.charAt(i) != getOpposite(alph)){
					list.add(original.charAt(i));
				}
			}
			int length = chomp(list);
			if (length < shortest){
				shortest = length;
			}
		}
		return shortest;
	}

	
	public boolean isOpposite(char c1, char c2){
		return Math.abs(c1-c2) == alphaConstant;
	}
	
	public char getOpposite(char c){
		return (c < 'a') ? (char) (c + alphaConstant) : (char) (c-alphaConstant);
	}
}
