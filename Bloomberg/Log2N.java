package Bloomberg;

public class Log2N {
	public boolean log2N(int n) {
		while (n > 1) {
			if (n % 2 != 0) {
				return false;
			}
			n /= 2;
		}
		return true;
	}

	public static void main(String args[]) {
		Log2N log = new Log2N();
		System.out.println(log.log2N(16));
	}
}
