package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		ArrayList<String> inputs = new ArrayList<String>();
		while (!(input = sc.nextLine()).isEmpty()){
			inputs.add(input);
		}
		Day3Solution sol = new Day3Solution(inputs);
		System.out.println(sol.sizeOfClaimed());
		System.out.println(sol.getNonOverlapped());
	}
}