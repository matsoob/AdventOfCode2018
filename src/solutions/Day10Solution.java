package solutions;

import java.util.ArrayList;

public class Day10Solution {
	ArrayList<Point> list = new ArrayList<Point>();
	public int xMax = Integer.MIN_VALUE;
	public int xMin = Integer.MAX_VALUE;
	public int yMax = Integer.MIN_VALUE;
	public int yMin = Integer.MAX_VALUE;
	
	public int size(){
		return list.size();
	}
	
	public Day10Solution(ArrayList<String> arr) {
		for (String s : arr){
			//position=<-10166, -20343> velocity=< 1,  2>
			String[] split = s.split("[<>,]");
			int x = Integer.parseInt(split[1].trim());
			if (x < xMin){
				xMin = x;
			}
			if (x > xMax){
				xMax = x;
			}
			int y = Integer.parseInt(split[2].trim());
			
			if (y < yMin){
				yMin = y;
			}
			if (y > yMax){
				yMax = y;
			}
			int xv = Integer.parseInt(split[4].trim());
			int yv = Integer.parseInt(split[5].trim());
			Point p = new Point(x,y,xv,yv);
			list.add(p);
		}
	}
	
	public void runUntilMinArea(){
		
		int xSpan = xMax - xMin;
		int ySpan = yMax - yMin;
		
		while (true){
			passTime();
			if (xSpan < xMax - xMin && ySpan < yMax - yMin) {
				System.out.println("xMax is " + xMax);
				System.out.println("yMax is" + yMax);
				System.out.println("xMin is " + xMin);
				System.out.println("yMin is" + yMin);
				break;
			} else {
				System.out.println("xMax is " + xMax);
				System.out.println("yMax is" + yMax);
				System.out.println("xMin is " + xMin);
				System.out.println("yMin is" + yMin);
				xSpan = xMax - xMin;
				ySpan = yMax - yMin;
			}
		}
		rewindTime();
		System.out.println("Current situation " + xMax + " " + xMin);
		output();
	}
	
	public void output(){
		char[][] array = new char[yMax - yMin+1][xMax - xMin+1];
		for (int i=0; i< yMax - yMin + 1; i++){
			for (int j=0; j<xMax - xMin + 1; j++){
				array[i][j] = '.';
			}
		}
		for (Point p: list){
			array[p.y - yMin][p.x - xMin] = '#';
		}
		for (int i=0; i<yMax - yMin + 1; i++){
			for (int j=0; j<xMax - xMin + 1; j++){
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
	
	public void passTime() {
		
		System.out.println("Incrementing once");
		
		xMax = Integer.MIN_VALUE;
		xMin = Integer.MAX_VALUE;
		yMax = Integer.MIN_VALUE;
		yMin = Integer.MAX_VALUE;
		for (Point p : list){
			p.incBy(1);
			if (p.x < xMin){
				xMin = p.x;
			}
			if (p.x > xMax){
				xMax = p.x;
			}
			if (p.y < yMin){
				yMin = p.y;
			}
			if (p.y > yMax){
				yMax = p.y;
			}
		}
		
	} 
	
	public void rewindTime() {
		
		xMax = Integer.MIN_VALUE;
		xMin = Integer.MAX_VALUE;
		yMax = Integer.MIN_VALUE;
		yMin = Integer.MAX_VALUE;
		for (Point p : list){
			p.turnBack(1);
			if (p.x < xMin){
				xMin = p.x;
			}
			if (p.x > xMax){
				xMax = p.x;
			}
			if (p.y < yMin){
				yMin = p.y;
			}
			if (p.y > yMax){
				yMax = p.y;
			}
		}
		
	}
}

class Point{
	
	protected int x;
	protected int y;
	int xv;
	int yv;
	
	public Point(int x, int y, int xv, int yv){
		this.x = x;
		this.y = y;
		this.xv = xv;
		this.yv = yv;
	}
	
	public void incBy(int seconds){
		x = x + (xv*seconds);
		y = y + (yv*seconds);
	}
	
	public void turnBack(int seconds){
		x = x - (xv*seconds);
		y = y - (yv*seconds);
	}
}