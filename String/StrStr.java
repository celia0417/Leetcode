package String;

public class StrStr {

	public int strStr(String haystack, String needle) {
	    if (needle.equals("")) return 0;
	    if (haystack.equals("")) return -1;
	    int m = 0, i = 0;
		int[] t = makeNext(needle.toCharArray());
		while (m + i < haystack.length()) {
			if (needle.charAt(i) == haystack.charAt(m + i)) {
				if (i == needle.length() - 1)
					return m;
				i++;
			} else {
				if (t[i] > -1) {
					m = m + i - t[i];
					i = t[i];
				} else {
					i = 0;
					m = m + 1;
				}
			}
		}
		return haystack.length();
	}

	private int[] makeNext(char[] w) {
		int len = w.length;
		int[] t = new int[len];
		int pos = 2, cnd = 0;
		t[0] = -1;
		if(len == 1) return t;
		t[1] = 0;
		while (pos < len) {
			if (w[pos - 1] == w[cnd]) {
				cnd++;
				t[pos] = cnd;
				pos++;
			} else if (cnd > 0) {
				cnd = t[cnd];
			} else {
				t[pos] = 0;
				pos++;
			}
		}
		return t;
	}

	public static void main(String args[]) {
		StrStr str = new StrStr();
		String s = "abaqwababw";
		char[] c = s.toCharArray();

		int[] res = str.makeNext(c);
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println(str.strStr("a", "a"));
	}
}
