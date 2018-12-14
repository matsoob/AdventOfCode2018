package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String initialLayout = sc.nextLine();
		sc.nextLine();
		String input;
		ArrayList<String> inputs = new ArrayList<String>();
		while (!(input = sc.nextLine()).isEmpty()){
			inputs.add(input);
		}
		Day12Solution sol = new Day12Solution(initialLayout, inputs);
		

	}

}
