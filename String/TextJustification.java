package String;

import java.util.*;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		int strLen = 0;
		int start = 0, end = 0;
		for (int i = 0; i < words.length; i++) {
			if (strLen == 0 || strLen + words[i].length() + 1 <= maxWidth) {
				if (strLen > 0)
					strLen++;
				strLen += words[i].length();
				end = i;
			} else {
				res.add(formLine(words, start, end, strLen, maxWidth));
				strLen = words[i].length();
				start = i;
				end = i;
			}
		}
		res.add(formLine(words, start, end, strLen, maxWidth));
		return res;
	}

	public String formLine(String[] words, int start, int end, int strLen, int maxWidth) {
		int N = end - start; // the number of words
		int M = maxWidth - strLen;
		StringBuilder sb = new StringBuilder();
		if (N == 0 || end == words.length - 1) {
			for (int i = start; i <= end; i++) {
				if (i > start)
					sb.append(" ");
				sb.append(words[i]);
			}
			for (int j = 0; j < M; j++)
				sb.append(" ");
		} else {
			for (int i = start; i <= end; i++) {
				if (i > start) {
					sb.append(" ");
					for (int j = 0; j < M / N; j++)
						sb.append(" ");
					if (i <= start + M % N)
						sb.append(" ");
				}
				sb.append(words[i]);
			}
		}
		return sb.toString();
	}
}
