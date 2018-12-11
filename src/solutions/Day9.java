package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Day9Solution sol = new Day9Solution();
		System.out.println("Highest score is " + sol.count(input));
	}

}
