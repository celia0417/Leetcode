package FB;

public class DotProductSparseMatrix {
	public int dotProduct(int[] x, int[] y) {
		if (x.length != y.length)
			throw new IllegalArgumentException("No dot product for two different length array");
		int res = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] != 0 && y[i] != 0)
				res += x[i] * y[i]; 
		}
		return res;
	}
}
