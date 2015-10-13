package HashTable;
import java.util.*;

public class CanPermutePalindrome {
	public boolean canPermutePalindrome(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}else{
				map.put(s.charAt(i), 1);
			}
		}

		int cnt = 0;
		for (Character key : map.keySet()) {
			if (map.get(key) % 2 == 1){
				cnt ++;
			}
			if (cnt > 1) return false;
		}
		return true;
	}
	
	public static void main (String args[]){
		CanPermutePalindrome cp = new CanPermutePalindrome();
		System.out.println(cp.canPermutePalindrome("asbbbbbb"));
	}
}
