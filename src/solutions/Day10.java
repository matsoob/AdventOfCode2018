package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		ArrayList<String> inputs = new ArrayList<String>();
		while (!(input = sc.nextLine()).isEmpty()){
			inputs.add(input);
		}
		
		Day10Solution sol = new Day10Solution(inputs);
		sol.runUntilMinArea();
		System.out.println("Current count is " + sol.seconds);

	}

}
