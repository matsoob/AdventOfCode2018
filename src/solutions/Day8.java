package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Day8Solution sol = new Day8Solution(input);
		System.out.println("Checksum is " + sol.checksum());
		System.out.println("Fancy checksum is " + sol.fancyChecksum());
	}
}
