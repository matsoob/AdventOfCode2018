package solutions;

public class Claim {
		
		public int id;
		public int x;
		public int y;
		public int width;
		public int height;
		public boolean overlapped;
		
		public Claim(String claimString){
			//eg #123 @ 3,2: 5x4
			String[] split = claimString.split("[#@,:x]");
			this.id = Integer.parseInt(split[1].trim());
			this.x = Integer.parseInt(split[2].trim());
			this.y = Integer.parseInt(split[3].trim());
			this.width = Integer.parseInt(split[4].trim());
			this.height = Integer.parseInt(split[5].trim());
			this.overlapped = false;
		}
	}
