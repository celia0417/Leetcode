package String;

import java.util.*;

public class EncodeDecodeStrings {
	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s.length()).append("/").append(s);
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> res = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			int slash = s.indexOf("/", i);
			int len = Integer.parseInt(s.substring(i, slash));
			String str = s.substring(slash + 1, slash + 1 + len);
			res.add(str);
			i = slash + len + 1;
		}
		return res;
	}
}
