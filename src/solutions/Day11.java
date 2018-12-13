package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input grid size: ");
		int input = sc.nextInt();
		System.out.println("Input rack id: ");
		int rack = sc.nextInt();
		Day11Solution sol = new Day11Solution(input, rack);
		
	}
}
