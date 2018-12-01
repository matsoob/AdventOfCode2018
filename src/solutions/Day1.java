package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
	// Assumptions:
	// input frequency drift is representable as a Java integer
	// total frequency drift happens within range of Java long
	// input given in STDIN in String form
	// End of input is signified with empty line
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Day1Solution solution = new Day1Solution();
		String number;
		while (!(number = sc.nextLine()).isEmpty()){
			solution.addString(number);
		}
		System.out.println(solution.getSum());
		System.out.println(solution.getRepeated());
	}
}