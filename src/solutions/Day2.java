package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {

//	To make sure you didn't miss any, 
// you scan the likely candidate boxes again, 
// counting the number that have an ID containing exactly two of any letter
//	and then separately counting those with exactly three of any letter. 
// You can multiply those two counts together to get a rudimentary checksum and 
// compare it to what your device predicts.
//
//	For example, if you see the following box IDs:
//
//	abcdef contains no letters that appear exactly two or three times.
//	bababc contains two a and three b, so it counts for both.
//	abbcde contains two b, but no letter appears exactly three times.
//	abcccd contains three c, but no letter appears exactly two times.
//	aabcdd contains two a and two d, but it only counts once.
//	abcdee contains two e.
//	ababab contains three a and three b, but it only counts once.
//	Of these box IDs, four of them contain a letter which appears exactly twice, and three of them contain a letter which appears exactly three times. Multiplying these together produces a checksum of 4 * 3 = 12.
//	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		ArrayList<String> inputs = new ArrayList<String>();
		while (!(input = sc.nextLine()).isEmpty()){
			inputs.add(input);
		}
		Day2Solution sol = new Day2Solution(inputs);
		System.out.println(sol.getCheckSum());
	}
}
