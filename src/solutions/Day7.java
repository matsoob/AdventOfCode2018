package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		ArrayList<String> inputs = new ArrayList<String>();
		while (!(input = sc.nextLine()).isEmpty()){
			inputs.add(input);
		}
		Day7Solution sol = new Day7Solution(inputs);
		System.out.println("Order of visiting : " + sol.getOrder());
		System.out.println("With parallel processing : " + sol.getTime(60, 5));
	}

}
