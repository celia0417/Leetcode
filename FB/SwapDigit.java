package FB;

public class SwapDigit {
	public static String swapDigit(String num) {
		int[] count = new int[10];
		for (int i = 0; i < num.length(); i ++) {
			count[num.charAt(i) - '0'] ++;
		}
		StringBuilder sb = new StringBuilder(num);
		for (int i = 0; i < num.length(); i ++) {
			int c = num.charAt(i) - '0';
			int j = 9;
			while (j > c && count[j] == 0) j --;
			if (j == c) {
				count[j] --;
				continue;
			}
			for (int k = num.length() - 1; k > i; k --) {
				if (num.charAt(k) -'0' == j) {
					sb.setCharAt(i, (char)(j + '0'));
					sb.setCharAt(k, (char)(c + '0'));
					break;
				}
			}
			break;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(swapDigit("3321"));
	}
}
