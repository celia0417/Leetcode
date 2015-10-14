package Snapchat;

public class PrintDiagonal {
	public void printDiagonal(int[][] nums) {
		int m = nums.length, n = nums[0].length;
		for( int k = 0 ; k < m + n ; k++ ) {
	        for( int j = k ; j >= 0 ; j-- ) {
	            int i = k - j;
	            if( i < m && j < n ) {
	                System.out.print( nums[i][j] + " " );
	            }
	        }
	        System.out.println();
	    }
	}

	public static void main(String args[]) {
		PrintDiagonal pd = new PrintDiagonal();
		pd.printDiagonal(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } });
		pd.printDiagonal(new int[][] { { 1, 2 }, { 5, 6 }, { 9, 10 } });
	}
}
