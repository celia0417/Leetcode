package Zenefits;

import java.util.*;

public class UneatenLeaves {
	public static int numberOfUneatenLeafs(int[] caterpiler, int n) throws Exception {
		if (caterpiler == null || caterpiler.length == 0 || n <= 0) {
			throw new Exception();
		}
		int count = n;
		Set<Long> set = new HashSet<Long>();
		for (int i = 0; i < caterpiler.length && count > 0; i++) {
			if (caterpiler[i] == 1) return 0;
			long pos = caterpiler[i];
			while (pos <= n && !set.contains(pos) && count > 0) {
				set.add(pos);
				pos += caterpiler[i];
				count--;
			}
		}
		return count;
	}
	
	public static int numberOfUneatenLeafs2(int[] caterpiler, int n) throws Exception {
		if (caterpiler == null || caterpiler.length == 0 || n <= 0) {
			throw new Exception();
		}
		int count = n;
		for (int i = 0; i < caterpiler.length; i++) {
			int gcd = caterpiler[i];
			for (int j = 0; j <= i && count > 0; j++){
				gcd = findGCD(caterpiler[j], caterpiler[i]);
				if(gcd > 1 && gcd < caterpiler[i]){
					break;
				}
			}
			if (gcd == caterpiler[i]){
				count -=  n/caterpiler[i];
				HashSet<Long> commonMultiples = new HashSet<Long>();
				for (int j = 0; j < i; j++){
					long lcm = lcm (caterpiler[j], caterpiler[i]);
					while(lcm <= n){
						commonMultiples.add(lcm);
						lcm += lcm;
					}
				}
				count += commonMultiples.size();
			}
		}
		return count;
	}
	
	private static long lcm (int a, int b){
		return a * (b / findGCD(a,b));
	}
	
	private static int findGCD(int number1, int number2){
		if (number2 == 0){
			return number1;
		}
		return findGCD(number2, number1%number2);
	}

	public static void main(String args[]) throws Exception {

		System.out.println(UneatenLeaves.numberOfUneatenLeafs2(new int[]{ 2, 4, 5 }, 11));
	}
}
