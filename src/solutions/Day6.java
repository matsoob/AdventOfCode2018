package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		ArrayList<String> inputs = new ArrayList<String>();
		while (!(input = sc.nextLine()).isEmpty()){
			inputs.add(input);
		}
		Day6Solution sol = new Day6Solution(inputs);
		System.out.println("Max area is" + sol.getMaxArea());
		System.out.println("Max safe region is " + sol.getSafeArea(10000));
	}
}
