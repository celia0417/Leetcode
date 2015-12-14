package Snapchat;

public class MergeSort {
	// public int[] sort(int[] arr) {
	// if (arr == null || arr.length == 0)
	// return arr;
	// int start = 0;
	// int end = arr.length - 1;
	// return mergeSort(arr, start, end);
	// }
	//
	// private int[] mergeSort(int[] arr, int start, int end) {
	// if (start == end) {
	// int[] ret = new int[1];
	// ret[0] = arr[start];
	// return ret;
	// }
	// int mid = start + (end - start) / 2;
	// int[] left = mergeSort(arr, start, mid);
	// int[] right = mergeSort(arr, mid + 1, end);
	// return merge(left, right);
	// }
	//
	// private int[] merge(int[] left, int[] right) {
	// int[] result = new int[left.length + right.length];
	// int l = 0;
	// int r = 0;
	// while (l < left.length && r < right.length) {
	// if (left[l] > right[r]) {
	// result[l + r] = right[r];
	// r++;
	// } else {
	// result[l + r] = left[l];
	// l++;
	// }
	// }
	// while (l < left.length) {
	// result[l + r] = left[l];
	// l++;
	// }
	// while (r < right.length) {
	// result[l + r] = right[r];
	// r++;
	// }
	// return result;
	// }

	public int[] sort(int[] arr) {
		if (arr == null || arr.length == 0)
			return arr;
		int start = 0;
		int end = arr.length - 1;
		return mergeSort(arr, start, end);
	}

	private int[] mergeSort(int[] arr, int start, int end) {
		if (start == end) {
			int[] ret = { arr[start] };
			return ret;
		}
		int mid = start + (end - start) / 2;
		int[] left = mergeSort(arr, start, mid);
		int[] right = mergeSort(arr, mid + 1, end);
		return merge(left, right);
	}

	private int[] merge(int[] left, int[] right) {
		int l = 0, r = 0;
		int[] result = new int[left.length + right.length];
		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				result[l + r] = left[l];
				l++;
			} else {
				result[l + r] = right[r];
				r++;
			}
		}
		while (l < left.length) {
			result[l + r] = left[l];
			l++;
		}
		while (r < right.length) {
			result[l + r] = right[r];
			r++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[] { 8, 4, 2, 6, 1, 0 };
		MergeSort test = new MergeSort();
		int[] result1 = test.sort(arr1);
		for (int i = 0; i < result1.length; i++) {
			System.out.print(result1[i] + " ");
		}
		System.out.println("");
		System.out.println("================");
		int[] arr2 = new int[] { -1, -2, 1, 983212, -8, -8 };
		int[] result2 = test.sort(arr2);
		for (int i = 0; i < result2.length; i++) {
			System.out.print(result2[i] + " ");
		}
		System.out.println("");
		System.out.println("================");
	}
}
