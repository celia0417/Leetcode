package Zillow;

public class StringToInteger {
	private static final long maxDiv10 = Long.MAX_VALUE / 10;

	public long myAtoi(String str) throws Exception {
		int i = 0, n = str.length();
		// while (i < n && Character.isWhitespace(str.charAt(i))) i++;
		if (str.contains(" "))
			throw new Exception("Illegal Input");
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
		StringToInteger si = new StringToInteger();
		try{
			System.out.println(si.myAtoi("1    234567891011"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(Long.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
}
