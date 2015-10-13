package FB;

import java.util.*;

public class SuffixSort {
	private static final Comparator<int[]> comparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] x, int[] y) {
			return x[0] - y[0];
		}
	};

	public int[] suffix(int[] text) {
		int[][] temp = new int[text.length][2];
		int[] res = new int[text.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i][0] = text[i];
			temp[i][1] = i;
		}
		Arrays.sort(temp, comparator);
		for (int i = 0; i < text.length; i++) {
			res[i] = temp[i][1];
		}
		return res;
	}

	public boolean subArray(int[] text, int[] order, int[] subtext) {
		int lookup = subtext[0], start = 0, end = text.length-1, lookupIndex = -1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if (text[order[mid]] < lookup){
				start = mid + 1;
			}else if (text[order[mid]] > lookup){
				end = mid -1;
			}else{
				lookupIndex = order[mid];
				break;
			}
		}
		if (lookupIndex == -1) return false;
		for (int i = lookupIndex, index = 0; index < subtext.length && i < text.length; i++, index ++){
			if (text[i] != subtext[index]){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SuffixSort sol = new SuffixSort();
		int text [] = new int[] { 10, 10, 30, 25 };
		int[] res = sol.suffix(text);
//		for (int i : res) {
//			System.out.println(i);
//		}
		int subtext [] = {10};
		System.out.println(sol.subArray(text, res, subtext));
	}
}
