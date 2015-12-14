package Google;

public class Compress {
	public String compress(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			if (Character.isDigit(sb.charAt(i))) {
				sb.insert(i + 1, "/");
				i++;
			}
		}
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < sb.length(); i++) {
			if (i - 1 >= 0 && sb.charAt(i) == '/' && Character.isDigit(sb.charAt(i - 1))) {
				if (i + 1 < sb.length())
					sb2.append(sb.charAt(i + 1));
				i += 2;
			}
			if (i >= sb.length()) break;
			int cnt = 1;
			while (i + 1 < sb.length() && Character.isAlphabetic(sb.charAt(i))
					&& Character.isAlphabetic(sb.charAt(i + 1)) && sb.charAt(i) == sb.charAt(i + 1)) {
				cnt++;
				i++;
			}
			if (cnt > 3) {
				sb2.append(cnt + "x" + sb.charAt(i));
			} else {
				while (cnt > 0) {
					cnt--;
					sb2.append(sb.charAt(i));

				}
			}
		}
		return sb2.toString();
	}

	public static void main(String args[]) {
		Compress c = new Compress();
		System.out.println(c.compress("3aaaaa"));
	}
}
