package BinarySearch;

public class FindMedian {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int k = (m + n) / 2;
		if ((m + n) % 2 == 1) {
			return (double) findK(nums1, 0, m, nums2, 0, n, k + 1);
		} else {
			int x1 = findK(nums1, 0, m, nums2, 0, n, k);
			int x2 = findK(nums1, 0, m, nums2, 0, n, k + 1);
			return (x1 + x2) / 2.0;
		}
	}

	public int findK(int[] nums1, int m0, int m, int[] nums2, int n0, int n, int k) {
		if (m < n)
			return findK(nums2, n0, n, nums1, m0, m, k);
		if (n <= n0)
			return nums1[m0 + k - 1];
		if (k == 1)
			return Math.min(nums1[m0], nums2[n0]);

		int j = Math.min(n, k / 2);
		int i = k - j;
		if (nums1[m0 + i - 1] > nums2[n0 + j - 1])
			return findK(nums1, m0, m-i, nums2, j, n, k - j);
		else if (nums1[m0 + i - 1] < nums2[n0 + j - 1])
			return findK(nums1, i, m, nums2, n0, j, k - i);
		else
			return nums1[m0 + i - 1];
	}

	public static void main(String args[]) {
		FindMedian bs = new FindMedian();
		// int nums1[] = { 1, 3, 4, 6, 8,9 };
		// int nums2[] = { 2, 5, 7 };
		int nums1[] = { 1 };
		int nums2[] = { 2 };
		System.out.println(bs.findMedianSortedArrays(nums1, nums2));
	}
}
