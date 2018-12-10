package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Day7Solution {
	
	ArrayList<Tuple> list = new ArrayList<>();
	HashSet<Character> set = new HashSet<>();

	public Day7Solution(ArrayList<String> inputs){
		for (String str : inputs){
			list.add(new Tuple(str.charAt(5), str.charAt(36)));
			set.add(str.charAt(5));
			set.add(str.charAt(36));
		}	
	}

	public String getOrder() {
		
		HashSet<Character> unrestricted = new HashSet<>();
		HashSet<Character> hasRestriction = new HashSet<>();
		for (Tuple t : list){
			if (!hasRestriction.contains(t.prereq)){
				unrestricted.add(t.prereq);
			}
			if (unrestricted.contains(t.secondary)){
				unrestricted.remove(t.secondary);
			}
			hasRestriction.add(t.secondary);
		}
		
		PriorityQueue<Character> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		HashSet<Character> visited = new HashSet<>();
		HashSet<Character> queued = new HashSet<>();
		
		for (char c : unrestricted){
			queue.add(c);
			queued.add(c);
		}

		
		while (!queue.isEmpty()){
			char c = queue.remove();
			visited.add(c);
			
			sb.append(c);
			
			HashSet<Character> nowUnrestricted = new HashSet<>();
			HashSet<Character> stillHasRestriction = new HashSet<>();
			
			for (Tuple t : list){
				if (visited.contains(t.prereq)
						&& !queued.contains(t.secondary)
						&& !stillHasRestriction.contains(t.secondary)){
					nowUnrestricted.add(t.secondary);
				}
				
				if (!visited.contains(t.prereq)){
					stillHasRestriction.add(t.secondary);
					if (nowUnrestricted.contains(t.secondary)){
						nowUnrestricted.remove(t.secondary);
					}
				}
			}
			
			for (char unlocked : nowUnrestricted){
				if (!visited.contains(unlocked)){
					queue.add(unlocked);
					queued.add(unlocked);
					System.out.println("Adding to queue " + unlocked);
				}
			}
		}
		
		return sb.toString();
	}

	public int getTime(int base, int workers) {
				
		HashSet<Character> unrestricted = new HashSet<>();
		HashSet<Character> hasRestriction = new HashSet<>();
		
		for (Tuple t : list){
			if (!hasRestriction.contains(t.prereq)){
				unrestricted.add(t.prereq);
			}
			if (unrestricted.contains(t.secondary)){
				unrestricted.remove(t.secondary);
			}
			hasRestriction.add(t.secondary);
		}
		
		PriorityQueue<Character> queue = new PriorityQueue<>();
		HashSet<Character> visited = new HashSet<>();
		HashSet<Character> queued = new HashSet<>();
		
		for (char c : unrestricted){
			queue.add(c);
			queued.add(c);
		}
		
		LinkedList<Work> workerQueue = new LinkedList<>();
		
		int seconds = 0;
		
		while (workerQueue.size() < workers && !queue.isEmpty()){
			workerQueue.add(new Work(queue.remove(), base));
		}
		
		while (!queue.isEmpty() || !workerQueue.isEmpty()){
			
			for (Work w : workerQueue){
				w.decrement();
			}
			seconds++;
			Iterator<Work> iter = workerQueue.iterator();
			while(iter.hasNext()) {
			  Work work = iter.next();
			  if(work.isComplete()) {
				visited.add(work.charcter);
			    iter.remove();
			  }
			}

			HashSet<Character> nowUnrestricted = new HashSet<>();
			HashSet<Character> stillHasRestriction = new HashSet<>();
			
			for (Tuple t : list){
				if (visited.contains(t.prereq)
						&& !queued.contains(t.secondary)
						&& !stillHasRestriction.contains(t.secondary)){
					nowUnrestricted.add(t.secondary);
				}
				
				if (!visited.contains(t.prereq)){
					stillHasRestriction.add(t.secondary);
					if (nowUnrestricted.contains(t.secondary)){
						nowUnrestricted.remove(t.secondary);
					}
				}
			}
			
			for (char unlocked : nowUnrestricted){
				if (!visited.contains(unlocked)){
					queue.add(unlocked);
					queued.add(unlocked);
					System.out.println("Adding to queue " + unlocked);
				}
			}
			
			while (workerQueue.size() < workers && !queue.isEmpty()){
				workerQueue.add(new Work(queue.remove(), base));
			}
			
		}
		
		return seconds;
	}
}

class Work{
	public char charcter;
	private int time;
	
	public Work(char c, int base){
		this.charcter = c;
		this.time = c - 'A' + 1 + base;
		System.out.println("Creating work " + c + " at " + this.time );
	}
	
	public boolean isComplete(){
		return time == 0;
	}
	
	public void decrement(){
		System.out.println("At " + charcter + " has " + time + " left");
		--time;
	}
}


class Tuple{
	
	char prereq;
	char secondary;
	
	public Tuple(char prereq, char secondary){
		this.prereq = prereq;
		this.secondary = secondary;
	}
}

