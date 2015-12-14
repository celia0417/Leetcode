package FB;

public class CountString {
	public String count(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int cnt = 1;
			char c = str.charAt(i);
			while (i < str.length() - 1 && c == str.charAt(i + 1)) {
				cnt++;
				i++;
			}
			sb.append(cnt).append(c);
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		CountString cs = new CountString();
		System.out.println(cs.count("AABBBCCCD"));
	}
}
