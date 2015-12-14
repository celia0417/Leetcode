package Google;

import java.util.*;

public class FetchPage {
	private int count = 0;

	public int count(String web) {
		count++;
		List<String> list = fetchPageAndExtractUrls(web);
		for (String s : list) {
			count(s);
		}
		return count;
	}

	List<String> fetchPageAndExtractUrls(String url) {
		List<String> list = new ArrayList<>();
		return list;
	}
}
