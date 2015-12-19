package Bloomberg;

public class PalindromeN {
	public boolean isPalindrome(int n) {
		int div = 1;
		while (n / div >= 10) {
			div *= 10;
		}
		while (div > 0) {
			int l = n / div;
			int r = n % 10;
			if (l != r)
				return false;
			n = (n % div) / 10;
			div /= 100;
		}
		return true;
	}
}
