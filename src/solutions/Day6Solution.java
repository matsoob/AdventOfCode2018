package solutions;

import java.util.ArrayList;
import java.util.HashSet;

public class Day6Solution {
	
	int minX = Integer.MAX_VALUE;
	int maxX = Integer.MIN_VALUE;
	int minY = Integer.MAX_VALUE;
	int maxY = Integer.MIN_VALUE;
	int[][] matrix;
	
	ArrayList<Coordinates> coords = new ArrayList<Coordinates>();
	
	public Day6Solution(ArrayList<String> inputs) {
		int id = 0;
		matrix = new int[400][400];
		for (String s : inputs){
			id++;
			String[] split = s.split(",");
			int x = Integer.parseInt(split[0].trim());
			int y = Integer.parseInt(split[1].trim());
			if (minX > x){
				minX = x;
			}
			if (maxX < x){
				maxX = x;
			}
			if (minY > y){
				minY = y;
			}
			if (maxY < y){
				maxY = y;
			}
			matrix[y][x] = id;
			coords.add(new Coordinates(x, y, id));
		}
		
		System.out.println("We have " + coords.size());
		System.out.println("Min x " + minX);
		System.out.println("Max x " + maxX);
		System.out.println("Min y " + minY);
		System.out.println("Max y " + maxY);
		
	
		
	}
	
	public int getMaxArea(){
		for (int i=minX; i<=maxX; i++){
			for (int j=minY; j<=maxY; j++){
				int minId;
				int minDistance = Integer.MAX_VALUE;
				for (Coordinates c: coords){
					int distance = Math.abs(c.x - i) + Math.abs(c.y - j);
					if (minDistance > distance){
						minDistance = distance;
						minId = c.id;
						matrix[j][i] = minId;
					} else if (minDistance == distance){
						minId = -1;
						matrix[j][i] = minId;
					}
				}
			}
		}
		
		HashSet<Integer> disq = new HashSet<Integer>();
		for (int i=minX; i<maxX; i++){
			if (matrix[minY][i] != -1){
				disq.add(matrix[minY][i]);
			}
			if (matrix[maxY][i] != -1){
				disq.add(matrix[maxY][i]);
			}
		}
		
		for (int i=minY; i<maxY; i++){
			if (matrix[i][minX] != -1){
				disq.add(matrix[i][minX]);
			}
			if (matrix[i][maxX] != -1){
				disq.add(matrix[i][maxX]);
			}
		}
		
		for (int i=0; i<400; i++){
			for (int j=0; j<400; j++){
				System.out.print(matrix[j][i] + ", ");
			}
			System.out.println();
		}
		
		int maxSize = 0;
		
		for (Coordinates c : coords){
			if (disq.contains(c.id)){
				System.out.println("Skipping disqualified line");
			} else {
				int size = 0;
				for (int i=minX; i<=maxX; i++){
					for (int j=minY; j<=maxY; j++){
						if (matrix[j][i] == c.id){
							size++;
						}
					}
				}
				if (maxSize < size){
					maxSize = size;
				}
			}
			
		}
		
		System.out.println("Max area is " + maxSize);
		return maxSize;
	}

	public int getSafeArea(int soup) {
		int safe = 0;
		for (int i=0; i<=500; i++){
			for (int j=0; j<=500; j++){
				long sum = 0;
				for (Coordinates c: coords){
					int distance = Math.abs(c.x - i) + Math.abs(c.y - j);
					sum += distance;
				}
				if (sum < soup){
					safe++;
				}
			}
		}
		return safe;
	}
}

class Coordinates{
	int id;
	int x;
	int y;
	public Coordinates(int x, int y, int id){
		this.id = id;
		this.x = x;
		this.y = y;
	}
}
