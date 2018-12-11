package solutions;

import java.util.ArrayList;
import java.util.LinkedList;

public class Day8Solution {

	String input;
	LinkedList<Integer> numbers = new LinkedList<>();
	Node root;
	
	public Day8Solution(String input){
		this.input = input;
		parse();
	}
	
	public long checksum(){
		return getMetadata(root);
	}
	
	private long getMetadata(Node start){
		long sum = 0;
		for (int i : start.metadata){
			sum += i;
		}
		for (Node n : start.children){
			sum += getMetadata(n);
		}
		return sum;
	}
	
	private void parse(){
		String[] split = input.split("\\s");
		int[] numbers = new int[split.length];
		for (int i=0; i<split.length; i++){
			numbers[i] = Integer.parseInt(split[i]);
		}
		root = new Node(new IntegerWrapper(0), numbers);
	}

	public int fancyChecksum() {
		return sum(root);
	}
	
	private int sum(Node start){
		if (start.children.length == 0){
			int sum = 0;
			for (int i : start.metadata){
				sum += i;
			}
			return sum;
		} else {
			int sum = 0;
			for (int i: start.metadata){
				if ( i > 0 && i <= start.children.length){
					sum += sum(start.children[--i]);
				}
			}
			return sum;
		}
	}
}

class Node {
	public Node[] children = {};
	public int[] metadata = {};
	public Node(IntegerWrapper pointer, int[] array){
		this.children = new Node[array[pointer.pointer]];
		pointer.pointer++;
		this.metadata = new int[array[pointer.pointer]];
		pointer.pointer++;
		for (int i=0; i<children.length; i++){
			children[i] = new Node(pointer, array);
		}
		for (int i=0; i<metadata.length; i++){
			metadata[i] = array[pointer.pointer];
			pointer.pointer++;
		}
	}
}

class IntegerWrapper {
	public int pointer;
	public IntegerWrapper(int p){
		this.pointer = p;
	}
}
