package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Day5Solution sol = new Day5Solution(input);
		System.out.println(sol.chompOriginal());
		System.out.println(sol.compareShortest());
		//ArrayList<String> inputs = new ArrayList<String>();
//		while (!(input = sc.nextLine()).isEmpty()){
//			inputs.add(input);
//		}
//		Day4Solution sol = new Day4Solution(inputs);
//		System.out.println(sol.getSleepiest());
//		System.out.println(sol.getMostFrequent());
	}
}