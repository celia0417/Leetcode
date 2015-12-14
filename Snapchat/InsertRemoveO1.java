package Snapchat;
import java.util.*;

public class InsertRemoveO1 {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int[] arr = new int[100];
	int index = 0;
	
	public void insert(int val){
		map.put(val, index);
		arr[index ++] = val;
	}
	
	public void remove(int val){
		arr[map.get(val)] = arr[index - 1];
		index--;
		map.remove(val);
	}
	
	public int getRandom(){
		int x = (int) (Math.random() * index);
		return arr[x];
	}
	
	public static void main(String args[]){
		InsertRemoveO1 ir = new InsertRemoveO1();
		ir.insert(1);
		ir.insert(2);
//		ir.remove(2);
		System.out.println(ir.getRandom());
		System.out.println(ir.getRandom());

		System.out.println(ir.getRandom());

		System.out.println(ir.getRandom());

		System.out.println(ir.getRandom());

		System.out.println(ir.getRandom());

	}
}
