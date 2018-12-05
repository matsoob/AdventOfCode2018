package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Day5Solution sol = new Day5Solution(input);
		System.out.println("Answer 1 : " + sol.chompOriginal());
		System.out.println("Answer 2 : " + sol.compareShortest());
	}
}