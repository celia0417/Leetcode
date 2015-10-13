package Snapchat;

public class StringCalculatorFourOperations {
	public String multiply(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
		int[] nums = new int[len1 + len2];
		int carry = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int k = num2.length() + i;
			for (int j = num2.length() - 1; j >= 0 || carry > 0; j--) {
				int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;
				int multiplication = val1 * val2 + nums[k] + carry;
				nums[k] = multiplication % 10;
				carry = multiplication / 10;
				k--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int num : nums) {
			sb.append(num);
		}
		while (sb.length() != 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}

	public String addition(String num1, String num2) {
		if (num1.equals("") || num2.equals(""))
			return "0";
		int len1 = num1.length(), len2 = num2.length();
		// negative number
		if (num1.charAt(0) == '-' && num2.charAt(0) != '-')
			return minus(num2, num1.substring(1, len1));
		else if (num1.charAt(0) != '-' && num2.charAt(0) == '-')
			return minus(num1, num2.substring(1, len2));
		else if (num1.charAt(0) == '-' && num2.charAt(0) == '-')
			return "-" + addition(num1.substring(1, len1), num2.substring(1, len2));

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
			int val1 = (i >= 0 ? num1.charAt(i) - '0' : 0);
			int val2 = (j >= 0 ? num2.charAt(j) - '0' : 0);
			int sum = val1 + val2 + carry;
			sb.insert(0, sum % 10);
			carry = sum / 10;
		}
		return sb.toString();
	}

	public String minus(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
		if (num1.equals("") || num2.equals(""))
			return "0";

		if (compare(num1, num2) == -1)
			return "-" + minus(num2, num1);

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
			int val1 = (i >= 0 ? num1.charAt(i) - '0' : 0);
			int val2 = (j >= 0 ? num2.charAt(j) - '0' : 0);
			int sum = val1 - val2 + carry;
			if (sum < 0) {
				sum += 10;
				carry = -1;
			}
			sb.insert(0, sum);
		}
		while (sb.length() != 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}

	public int compare(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
		if (len1 < len2)
			return -1;
		else if (len1 == len2) {
			int x = 0;
			while (x < len1 && (num1.charAt(x) - '0') == (num2.charAt(x) - '0')) {
				x++;
			}
			if (x < len1 && (num1.charAt(x) - '0') < (num2.charAt(x) - '0'))
				return -1;
		}
		return 1;
	}

	public String divide(String num1, String num2) {
		while(compare(num1, num2) == -1){
			
		}
		return "";
	}

	public static void main(String args[]) {
		StringCalculatorFourOperations sc = new StringCalculatorFourOperations();
		System.out.println(sc.minus("15", "15"));
	}
}
