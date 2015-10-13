package Array;

import java.util.*;

public class PascalTriangle {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
		if(rowIndex < 0) return list;
        for(int i =0; i<rowIndex+1; i++){
            list.add(0,1);
            for (int j=1;j<i;j++){
            	list.set(j,list.get(j)+list.get(j+1));
            }
        }
		return list;
    }
	
	public static void main(String args[]){
		PascalTriangle pt = new PascalTriangle();
		List<Integer> list = pt.getRow(0);
		for (int i :list){
			System.out.println(i);
		}
	}
}
