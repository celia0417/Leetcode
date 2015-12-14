package Zenefits;

public class LargestAK {
	public int findLargestK(String s1, String s2) {
		if (s1.length() < 1 || s1.length() > s2.length())
			return -1;
		int k = 1;
		int left = 1, right = s2.length() / s1.length();
		int lastK = -1;
		while (left <= right) {
			k = left + (right - left) / 2;
			String akString = generateKth(s1, k);
			if (isSub(akString, s2)) {
				lastK = k;
				left = k + 1;
			} else {
				right = k - 1;
			}
		}
		return lastK;
	}

	private String generateKth(String s, int k) {
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < k; j++) {
				temp.append(s.charAt(i));
			}
		}
		return temp.toString();
	}

	private boolean isSub(String s1, String s2) {
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
			}
			j++;
		}
		if (i == s1.length())
			return true;
		return false;
	}

	public static void main(String[] args) {
		LargestAK ak = new LargestAK();
		String s1 = "ab";
		String s2 = "acaaabcbbb";
		String s3 = "xyxz";
		String s4 = "xxyyxxzz";
		System.out.println(ak.findLargestK(s1, s2));
	}

}
