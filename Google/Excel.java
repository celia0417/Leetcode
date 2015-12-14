package Google;

public class Excel {
	public String convertToTitle(int n) {
		StringBuilder str = new StringBuilder();
		if (n == 0)
			return "";
		while (n >= 0) {
			str.insert(0, (char) (n % 26 + 'A'));
			n = n / 26 - 1;
		}
		return str.toString();
	}

	public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            res = res * 26 + s.charAt(i) - 'A';
            if (i != s.length() - 1) res ++;
        }
        return res;
    }	
}
