package Google;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitString {
	public List<String> split(String str) {
		// List<String> list = new ArrayList<String>();
		// Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(str);
		// while (m.find())
		// list.add(m.group(1)); // Add .replace("\"", "") to remove
		// // surrounding quotes.
		//
		// System.out.println(list);
		// return list;

		List<String> matchList = new ArrayList<String>();
//		Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
		Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"");

		Matcher regexMatcher = regex.matcher(str);
		while (regexMatcher.find()) {
			if (regexMatcher.group(1) != null) {
				// Add double-quoted string without the quotes
				matchList.add(regexMatcher.group(1));
//			} else if (regexMatcher.group(2) != null) {
//				// Add single-quoted string without the quotes
//				matchList.add(regexMatcher.group(2));
			} else {
				// Add unquoted word
				matchList.add(regexMatcher.group());
			}
		}
		return matchList;
	}

	public static void main(String args[]) {
		SplitString ss = new SplitString();
		List<String> matchList = ss.split("Location \"Welcome  to india\" Bangalore " + "Channai \"IT city\"  Mysore");
		for (String s : matchList) {
			System.out.println(s);
		}
	}
}
