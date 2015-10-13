package String;

public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;
		String newString = s + "#" + new StringBuilder(s).reverse().toString();
		int pos[] = new int[newString.length()];
		for (int i = 1; i < newString.length(); i++) {
			int pre = pos[i - 1];
			while (pre > 0 && newString.charAt(pre) != newString.charAt(i))
				pre = pos[pre - 1];
			pos[i] = pre + (newString.charAt(pre) == newString.charAt(i) ? 1 : 0);
		}
		return new StringBuilder(s.substring(pos[pos.length - 1])).reverse().toString() + s;
	}

	public String shortestPalindrome2(String s) {
		if (s == null || s.length() == 0)
			return s;

		int pos[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			int pre = pos[i - 1];
			while (pre > 0 && s.charAt(pre) != s.charAt(i))
				pre = pos[pre - 1];
			pos[i] = pre + (s.charAt(pre) == s.charAt(i) ? 1 : 0);
		}

		String reverseString = new StringBuilder(s).reverse().toString();
		int pre = 0, cur = 0;
		for (int i = 0; i < reverseString.length(); i++) {
			pre = cur;
			while (pre > 0 && s.charAt(pre) != reverseString.charAt(i))
				pre = pos[pre - 1];
			cur = pre + (s.charAt(pre) == reverseString.charAt(i) ? 1 : 0);
		}
		return new StringBuilder(s.substring(cur)).reverse().toString() + s;
	}

	public static void main(String args[]) {
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println(sp.shortestPalindrome2("abac"));
	}
}
