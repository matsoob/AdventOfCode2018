package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day3Solution {
	
	HashMap<Integer, Claim> claims;
	int[][][] fabric;
	int doublyClaimed;
	
	public Day3Solution(ArrayList<String> inputs){
		this.fabric = new int[1000][1000][2];
		this.doublyClaimed = 0;
		
		this.claims = new HashMap<>();
		for (String s : inputs){
			Claim c = new Claim(s);
			claims.put(c.id, c);
		}
		processClaims();
	};
	
	//bruteforce :(
	public void processClaims(){
		for (Claim c : claims.values()){
			for (int x=0; x<c.width; x++){
				for (int y=0; y<c.height; y++){
					if (this.fabric[c.y + y][c.x + x][0] >= 1){
						this.claims.get(this.fabric[c.y + y][c.x + x][1]).overlapped = true;
						claims.get(c.id).overlapped = true;
					}
					if (this.fabric[c.y + y][c.x + x][0] == 1){
						doublyClaimed++;
					}
					this.fabric[c.y + y][c.x + x][0]++;
					this.fabric[c.y + y][c.x + x][1] = c.id;
				}
			}			
		}
	}
	
	public int sizeOfClaimed(){
		return doublyClaimed;
	}
	
	public int getNonOverlapped(){
		//Claim target;
		List<Claim> nonOverLapping = claims.values().stream()
			.filter(claim -> {return !claim.overlapped; })
			.collect(Collectors.toList());
			
		if (nonOverLapping.size() != 1){
			throw new IllegalArgumentException("Input produced more than one non-overlapping claim. Check if this is valid");
		}
		return nonOverLapping.get(0).id;
	}

}

