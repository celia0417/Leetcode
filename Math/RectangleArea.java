package Math;

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap = 0 ;
        if (E > C || A > G) 
            overlap = 0;
        else
            overlap = Math.max(0, Math.min(C, G) - Math.max(A, E)) * Math.max(0, Math.min(D, H) - Math.max(B, F));
        return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
    }
	
	public static void main (String args[]){
		RectangleArea ra = new RectangleArea();
		System.out.println(ra.computeArea(-1500000001,0,-1500000000,1,1500000000,0,1500000001,1));
	}
}
