package String;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int carry = 0;
		StringBuffer res = new StringBuffer();
		int num[] = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			int value1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int k = num2.length() + i;
			for (int j = num2.length() - 1; j >= 0 || carry > 0; j--) {
				int value2 = j >= 0 ? num2.charAt(j) - '0' : 0;
				int multiplication = value1 * value2 + num[k] + carry;
				num[k] = multiplication % 10;
				carry = multiplication / 10;
				k--;
			}
		}
		for (int i : num) {
			res.append(i);
		}
        while (res.length() != 0 && res.charAt(0) == '0') res.deleteCharAt(0);
		return res.toString();
	}

	public static void main(String args[]) {
		MultiplyStrings ms = new MultiplyStrings();
		System.out.println(ms.multiply("123", "456"));
	}
}
