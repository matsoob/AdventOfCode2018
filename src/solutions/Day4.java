package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		ArrayList<String> inputs = new ArrayList<String>();
		while (!(input = sc.nextLine()).isEmpty()){
			inputs.add(input);
		}
		Day4Solution sol = new Day4Solution(inputs);
		System.out.println(sol.getSleepiest());
		System.out.println(sol.getMostFrequent());
	}
}
