package Zenefits;

//public class StringToNumber {
// Q2. Given a string like '676870' output 69

// '9899100102' - > 101
// '98100101102103' - > 99 - forget this temporarily
// '9810098102' -> 98101
// '99100101103' - > 102

import java.util.HashMap;
import java.util.Map;

public class NumberofDigits {
	
	public static void main(String[] args) {
		String s = "98100101102103";
		
		int missingNum = find(s);
		System.out.print("" + missingNum);
	}
	
	public static int find (String s){
		int missingNum = -1;

		for (int startLen = 1; startLen <= s.length() / 2 && missingNum == -1; startLen++) {
			int prevNum = getInt(s, 0, startLen);
			int offset = startLen;

			while (true) {

				int nextA = prevNum + 1;
				int lenA = intLen(nextA);
				int nextB = prevNum + 2;
				int lenB = intLen(nextB);

				//check +1
				if (offset + lenA > s.length()) {
					missingNum = -1;
					break; //wrong sequence
				}
				int gotNum = getInt(s, offset, lenA);
				if (gotNum == nextA) {
					prevNum = nextA;
					offset += lenA;
					if (offset == s.length()) break; // found
					continue;
				}

				if (missingNum != -1) {
					missingNum = -1;
					break; //wrong sequence
				}

				//check +2
				if (offset + lenB > s.length()) {
					missingNum = -1;
					break; //wrong sequence
				}
				gotNum = getInt(s, offset, lenB);
				if (gotNum == nextB) {
					prevNum = nextB;
					offset += lenB;
					missingNum = nextA;
					if (offset == s.length()) break; // found
					continue;
				}
				
				missingNum = -1;
				break; //wrong sequence
			}
		}
		return missingNum;
	}

	private static int getInt(String s, int off, int len) {
		String num = s.substring(off, off+len);
		return Integer.parseInt(num);
	}

	private static int intLen(int num) {
		int len = 0;
		while (num> 0){
			num /= 10;
			len++;
		}
		return len;
	}

}
