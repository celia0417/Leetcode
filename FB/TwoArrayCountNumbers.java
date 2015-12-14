package FB;

import java.util.*;

public class TwoArrayCountNumbers {
	public int[] count (int a[], int b[]){
		int [] res = new int [b.length];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : a){
			
		}
		Map<Integer, Set<Integer>> count = new HashMap<Integer, Set<Integer>>();
		for (int key : map.keySet()){
			if(count.containsKey(map.get(key))){
				count.get(map.get(key)).add(key);
			}else count.put(map.get(key), new HashSet<Integer>(Arrays.asList(key)));
		}
		for (int i = 0; i < b.length; i++){
			
		}
		return null;
	}
	
	
}
