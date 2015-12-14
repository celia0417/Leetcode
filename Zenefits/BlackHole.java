package Zenefits;

import java.util.*;

public class BlackHole {
	// Q2: 0 and 9999

	// 3241 -> 4321 - 1234 = result -> repeat

	// 3087 -> 8730 - 0378 = 8352

	// 8352 -> 8532 - 2358 = 6174

	// 6174 -> 7641 - 1467 = 6174

	// 23 -> 0023 -> 3200 - 0023 -> ...

	// Find all numbers between 0 and 9999 for which the above procedure does
	// not end in 6174.

	public void intRes() {
		for (int i = 0; i <= 9999; i++) {
			int cur = -1;
			int newInt = i;
			while (newInt != cur) {
				cur = newInt;
				int asc = convertAsc(cur);
				int des = convertDesc(cur);
				newInt = des - asc;
			}
			if (newInt != 6174)
				System.out.println(i);
		}
	}

	public int convertAsc(int num) {
		int[] temp = new int[4];
		int cnt = 0;
		while (num > 0) {
			temp[cnt++] = num % 10;
			num /= 10;
		}
		Arrays.sort(temp);
		int res = 0;
		for (int i = 0; i < cnt; i++) {
			res = res * 10 + temp[i];
		}
		return res;
	}

	public int convertDesc(int num) {
		int[] temp = new int[4];
		int cnt = 0;
		while (num > 0) {
			temp[cnt++] = num % 10;
			num /= 10;
		}
		Arrays.sort(temp);
		int res = 0;
		for (int i = 3; i >= 0; i--) {
			res = res * 10 + temp[i];
		}
		return res;
	}

	public static void main(String args[]) {
		BlackHole sol = new BlackHole();
		sol.intRes();
	}

}
