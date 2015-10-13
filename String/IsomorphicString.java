package String;

import java.util.*;

public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Character> table = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			if (table.containsKey(s.charAt(i))) {
				if (table.get(s.charAt(i)) != t.charAt(i))
					return false;
			} else if (table.containsValue(t.charAt(i))) {
				return false;
			}else
				table.put(s.charAt(i), t.charAt(i));
		}
		return true;
	}

	public static void main(String args[]) {
		IsomorphicString is = new IsomorphicString();
		System.out.println(is.isIsomorphic("ab", "aa"));
	}
}
