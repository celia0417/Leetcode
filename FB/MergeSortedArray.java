package FB;

import java.util.*;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}

	class Element {
		int val;
		int index;
		int pos;

		public Element(int val, int index, int pos) {
			this.val = val;
			this.index = index;
			this.pos = pos;
		}
	}

	private static final Comparator<Element> comparator = new Comparator<Element>() {
		@Override
		public int compare(Element e1, Element e2) {
			return e1.val - e2.val;
		}
	};

	public List<Integer> mergeKSorted(List<int[]> lists) {
		List<Integer> res = new ArrayList<Integer>();
		Queue<Element> q = new PriorityQueue<Element>(lists.size(), comparator);
		for (int i = 0; i < lists.size(); i++) {
			Element e = new Element(lists.get(i)[0], 0, i);
			q.add(e);
		}
		while (!q.isEmpty()) {
			Element cur = q.poll();
			res.add(cur.val);
			if (cur.index + 1 < lists.get(cur.pos).length) {
				Element next = new Element(lists.get(cur.pos)[cur.index + 1], cur.index + 1, cur.pos);
				q.offer(next);
			}
		}
		return res;
	}

	public static void main(String args[]) {
		MergeSortedArray msa = new MergeSortedArray();
		int [] l1 = {3,4,5,7,10};
		int [] l2 = {1,6,9,14};
		int [] l3 = {2,4,9,11,19};
		List<int[]> lists = new ArrayList<>(Arrays.asList(l1,l2,l3));
		
		List<Integer> res = msa.mergeKSorted(lists);
		for (int i : res){
			System.out.println(i);
		}
	}
}
