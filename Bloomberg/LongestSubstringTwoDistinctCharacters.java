package Bloomberg;

public class LongestSubstringTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int start = 0, last = -1, max = 0;
		for (int cur = 1; cur < s.length(); cur++) {
			if (s.charAt(cur) != s.charAt(cur - 1)) {
				if (last >= 0 && s.charAt(cur) != s.charAt(last)) {
					max = Math.max(cur - start, max);
					start = last + 1;
				}
				last = cur - 1;
			}
		}
		return Math.max(s.length() - start, max);
	}

	public static void main(String args[]) {
		LongestSubstringTwoDistinctCharacters ll = new LongestSubstringTwoDistinctCharacters();
		System.out.println(ll.lengthOfLongestSubstringTwoDistinct("eceba"));
	}
}
