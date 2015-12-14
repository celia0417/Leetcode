package Google;

import java.util.*;

class Rectangle{
	int a, b, c, d;
	
	public Rectangle (int a, int b, int c , int d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
}


public class RectangularOverlapping {
	public int overlap(int A, int B, int C, int D, int E, int F, int G, int H){
		int left = Math.max(A, E), right = Math.max(Math.min(C, G), left);
		int bottom = Math.max(B, F), top = Math.max(bottom, Math.min(H,D));
		return (right - left) * (top - bottom);
	}
	
	private static final Comparator<Rectangle> comparator = new Comparator<Rectangle>(){

		@Override
		public int compare(Rectangle o1, Rectangle o2) {
			return o1.a- o2.a;
		}
		
	};
	
	public int multiOverlap (List<Rectangle> input){
		Collections.sort(input, comparator);
		int res = 0;
		for (int i = 1; i < input.size(); i++){
			Rectangle r1 = input.get(i -1);
			Rectangle r2 = input.get(i);
			if (r2.a < r1.c){
				int bottom = Math.max(r1.b, r2.b), top = Math.max(bottom, Math.min(r1.d, r1.d));
				res += (r2.a - r1.c) * (top-bottom); 
			}
		}
		return 0;
	}
}
