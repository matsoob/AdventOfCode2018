package solutions;

public class Day9Solution {

	public long count(String testCase4) {
		
		String[] split = testCase4.split("\\s");
		
		int players = Integer.parseInt(split[0]);
		int marbles = Integer.parseInt(split[6]);
		long[] playerScores = new long[players];
		
		Marble current = new Marble(0);
		current.next = current;
		current.prev = current;
		
		int currentPlayer = 0;
		
		for (int i=1; i<=marbles; i++){
			//System.out.println("Current player is " + (currentPlayer+1));
			//System.out.println("Current marble is " + current.value);
			if (i % 23 == 0){
				playerScores[currentPlayer] = playerScores[currentPlayer] + i;
				for (int j=0; j<7; j++){
					current = current.prev;
				}
				Marble prev = current.prev;
				Marble next = current.next;
				playerScores[currentPlayer] = playerScores[currentPlayer] + current.value;
				prev.next = next;
				next.prev = prev;
				current = next;
			} else {
				//System.out.println("Inserting marble " + i);
				Marble newNode = new Marble(i);
				current = current.next;
				Marble temp = current.next;
				current.next = newNode;
				newNode.prev = current;
				newNode.next = temp;
				temp.prev = newNode;
				current = newNode;
			}
			currentPlayer = (currentPlayer + 1) % players;
		}
		long max = 0;
		for (long l : playerScores){
			if (l > max){
				max = l;
			}
		}
		return max;
		
	}

}

class Marble {
	public int value;
	public Marble prev;
	public Marble next;
	public Marble(int v){
		this.value = v;
	}
}
