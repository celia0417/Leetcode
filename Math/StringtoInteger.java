package Math;

public class StringtoInteger {
	private static final long maxDiv10 = Long.MAX_VALUE / 10;

	public long myAtoi(String str) {
		int i = 0, n = str.length();
		while (i < n && Character.isWhitespace(str.charAt(i)))
			i++;
		long sign = 1;
		if (i < n && str.charAt(i) == '+') {
			i++;
		} else if (i < n && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		long num = 0;
		while (i < n && Character.isDigit(str.charAt(i))) {
			int digit = Character.getNumericValue(str.charAt(i));
			if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
				return sign == 1 ? Long.MAX_VALUE : Long.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	}
	
	public static void main (String args[]){
		StringtoInteger si = new StringtoInteger();
		System.out.println(si.myAtoi("12345678910111213"));
	}
}
