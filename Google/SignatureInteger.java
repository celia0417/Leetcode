package Google;

import java.util.*;

public class SignatureInteger {
	public List<Integer> getTrend(String s){
		List<Integer> l = new ArrayList<>();
		l.add(1);
		int num = l.get(0);
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == 'i'){
				l.add(i+2);
				num = l.get(l.size()-1);
				num --;
			}
			else {
				l.add(num, i+2);
				System.out.println(l);
				num--;
			}
		}
		return l;
	}
	
	public static void main (String args[]){
		SignatureInteger si = new SignatureInteger();
		List<Integer> res = si.getTrend("iid");
		for (int i : res){
			System.out.println(i);
		}
	}
}
