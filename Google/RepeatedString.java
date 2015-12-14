package Google;

public class RepeatedString {
	public boolean repeatedString(String s){
		int n = s.length();
		for (int i = 1; i < n; i++){
			if (n % i == 0){
				String pre = s.substring(0, 0 + i);
				int start = i;
				while (start + i <= s.length() && pre.equals(s.substring(start, start + i))){
					start += i;
				}
				if (start + i > s.length()) return true;
			}
		}
		return false;
	}
	
	public static void main (String args[]){
		RepeatedString rs = new RepeatedString();
		System.out.println(rs.repeatedString("abcabcabc"));
	}
}
