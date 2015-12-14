package Google;

public class DoubleMinimumWindow {
	public int getRange(double[] input){
		int start = 0, max = 0;
		for (int i = 1; i < input.length; i++){
			if (input[i] - input[start] >= 1){
				while (input[i] - input[start] > 1){
					start ++;
				}
			}
			max = Math.max(i - start  + 1, max);
		}
		return max;
	}
	
	public static void main (String args[]){
		DoubleMinimumWindow dmw = new DoubleMinimumWindow();
		System.out.println(dmw.getRange(new double [] {1.1,1.2,1.3,2.2,3.1,4.1}));
	}
}

