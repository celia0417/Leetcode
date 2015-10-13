package TwoPointers;

import java.util.*;

public class SubstringConcatenationAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		int wordLen = words[0].length();
		if (s.length() == 0 || wordLen == 0 || s.length() < wordLen * words.length)
			return res;

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (map.containsKey(word))
				map.put(word, map.get(word) + 1);
			else
				map.put(word, 1);
		}
		for (int i = 0; i < wordLen; i++) {
			int count = 0, pre = i;
			Map<String, Integer> mapS = new HashMap<String, Integer>();
			for (int j = i; j <= s.length() - wordLen; j += wordLen) {
				String cur = s.substring(j, j + wordLen);
				if (!map.containsKey(cur)) {
					count = 0;
					pre = j + wordLen;
					mapS.clear(); // move pre to next
				} else {
					if (!mapS.containsKey(cur))
						mapS.put(cur, 1);
					else
						mapS.put(cur, mapS.get(cur) + 1);
					if (mapS.get(cur) <= map.get(cur))
						count++;
					else {
						while (mapS.get(cur) > map.get(cur)) {
							String preWord = s.substring(pre, pre + wordLen);
							mapS.put(preWord, mapS.get(preWord) - 1);
							if (mapS.get(preWord) < map.get(preWord))
								count--;
							pre += wordLen;
						}
					}

					if (count == words.length) {
						res.add(pre);
						String preWord = s.substring(pre, pre + wordLen);
						mapS.put(preWord, mapS.get(preWord) - 1);
						count--;
						pre += wordLen;
					}
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		SubstringConcatenationAllWords scw = new SubstringConcatenationAllWords();
		String words[] = { "word","good","best","good" };
		List<Integer> res = scw.findSubstring("wordgoodgoodgoodbestword", words);
		for (int i : res){
			System.out.println(i);
		}
	}
}
