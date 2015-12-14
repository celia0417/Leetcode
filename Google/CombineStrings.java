package Google;

import java.util.*;


public class CombineStrings {
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		String[] arr = { "abc%cde", "a#aa", "haha" };
//		for (String s : arr) {
//			System.out.println(s);
//		}
		String result = serialize(arr);
		System.out.println(result);
		String[] newArr = deserialize(result);
		for (String s : newArr) {
			System.out.println(s);
		}
	}

	public static String serialize(String[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append(arr.length + "#");
		for (String s : arr) {
			sb.append(s.length() + "%");
		}
		for (String s : arr) {
			sb.append(s);
		}
		return sb.toString();
	}

	public static String[] deserialize(String s) {
		String[] sizeAndContent = s.split("#");
		int len = Integer.parseInt(sizeAndContent[0]);
		s = s.substring(sizeAndContent[0].length() + 1);
		String[] eachSize = s.split("%");
		int[] size = new int[len];
		int total = 0;
		for (int i = 0; i < len; i++) {
			size[i] = Integer.parseInt(eachSize[i]);
			total += size[i];
		}
		String content = s.substring(s.length() - total, s.length());
		String[] result = new String[len];
		for (int i = 0; i < len; i++) {
			result[i] = content.substring(0, size[i]);
			content = content.substring(size[i]);
		}
		return result;
	}
}
