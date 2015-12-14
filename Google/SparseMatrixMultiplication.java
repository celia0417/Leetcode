package Google;

import java.util.*;

class Matrix {
	int i;
	int j;
	int val;
	public Matrix (int i, int j, int val){
		this.i = i;
		this.j = j;
		this.val = val;
	}
}

public class SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		int m = A.length, n = A[0].length, nB = B[0].length;
	    int[][] result = new int[m][nB];

	    Map<Integer, List<Matrix>> mapA = new HashMap<>();
	    for(int i = 0; i < m; i++) {
	    	mapA.put(i, new ArrayList<>());
	        for(int j = 0; j < n; j++) {
	            if(A[i][j] != 0){
	            	mapA.get(i).add(new Matrix(i, j , A[i][j]));
	            }
	        }
	    }
	    
	    Map<Integer, List<Matrix>> mapB = new HashMap<>();
	    for(int i = 0; i < n; i++) {
	    	mapB.put(i, new ArrayList<>());
	        for(int j = 0; j < nB; j++) {
	            if(B[i][j] != 0){
	            	mapB.get(i).add(new Matrix(i, j , B[i][j]));
	            }
	        }
	    }
	    
	    for (int i : mapA.keySet()){
	    	for (Matrix matrixa : mapA.get(i)){
	    		for (Matrix  matrixb: mapB.get(matrixa.j)){
	    			result[i][matrixb.j] += matrixa.val * matrixb.val;
	    		}
	    	}
	    }
	    
	    return result; 
    }
	
	public static void main (String args[]){
		SparseMatrixMultiplication smm = new SparseMatrixMultiplication();
		smm.multiply(new int [][] {{1,0,0}, {-1, 0, 3}}, new int [][] {{7,0,0},{0,0,0},{0,0,1}});
	}
}
