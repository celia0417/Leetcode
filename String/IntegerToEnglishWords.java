package String;

public class IntegerToEnglishWords {
	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		String thousands[] = { "", "Thousand", "Million", "Billion" };
		String res = "";
		int i = 0;
		while (num > 0) {
			if (num % 1000 != 0)
				res = helper(num % 1000) + thousands[i] + " " + res;

			num /= 1000;
			i++;
		}
		return res.trim();
	}

	public String helper(int num) {
		String lessThanTwenty[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
		String tens[] = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		if (num == 0)
			return "";
		else if (num < 20) {
			return lessThanTwenty[num] + " ";
		} else if (num < 100) {
			return tens[num / 10] + " " + helper(num % 10);
		} else {
			return lessThanTwenty[num / 100] + " Hundred " + helper(num % 100);
		}

	}

	public static void main(String args[]) {
		IntegerToEnglishWords itew = new IntegerToEnglishWords();
		System.out.println(itew.numberToWords(123));
	}
}
