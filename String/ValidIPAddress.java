package String;

import java.util.*;

public class ValidIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s.length() > 12)
			return res;
		for (int i = 1; i < s.length() - 2; i++) {
			for (int j = i + 1; j < s.length() - 1; j++) {
				for (int z = j + 1; z < s.length(); z++) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, z),
							s4 = s.substring(z, s.length());
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return res;
	}

	public boolean isValid(String s) {
		if (s.length() > 3)
			return false;
		if (s.length() != 1 && s.charAt(0) == '0')
			return false;
		if (s.length() == 3 && Integer.parseInt(s) > 255)
			return false;
		return true;
	}

	public static void main(String args[]) {
		ValidIPAddress va = new ValidIPAddress();
		System.out.println(va.restoreIpAddresses("25525511135"));
	}
}
