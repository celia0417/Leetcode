package Bloomberg;

public class Rand7 {
	static java.util.Random r = new java.util.Random();

	static int rand5() {
		return r.nextInt(5) + 1; // Random.nextInt(n) returns 0..n-1, so add 1
	}

	int rand7() {
		int n = 0;
		do {
			// each number appear with probability 4%
			n = 5 * rand5() + rand5();
		} while (n > 20);
		// data in range [1, 21]
		return n % 7;
	}

}
