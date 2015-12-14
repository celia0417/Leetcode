package Zenefits;

public class KthSmallestTwoSortedArray {
	public static int ksmallest(int[] a, int[] b, int a1, int a2, int b1, int b2, int k) {
		int lena = a2 - a1;
		int lenb = b2 - b1;
		assert (0 <= k && k < (lena + lenb));
		if (lena == 0) {
			return b[b1 + k];
		}
		if (lenb == 0) {
			return a[a1 + k];
		}
		int mida = lena / 2;
		int midb = lenb / 2;
		int ma = a[a1 + mida];
		int mb = b[b1 + midb];
		if ((mida + midb) < k) {
			return (mb < ma) ? ksmallest(a, b, a1, a2, b1 + midb + 1, b2, k - (midb + 1))
					: ksmallest(a, b, a1 + mida + 1, a2, b1, b2, k - (mida + 1));
		} else {
			return (mb < ma) ? ksmallest(a, b, a1, a1 + mida, b1, b2, k) : ksmallest(a, b, a1, a2, b1, b1 + midb, k);
		}
	}
	
	public static int k(int[] a, int[]b, int k){
		return ksmallest(a,b,0, a.length, 0, b.length,k-1);
	}
	
	public static void main (String args[]){
		KthSmallestTwoSortedArray ks = new KthSmallestTwoSortedArray();
		System.out.println(ks.k(new int [] {2,3,6,9,10}, new int []{1,3,5,7}, 4));
	}
}
