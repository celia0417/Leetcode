package Google;

public class FirstOf {
	public int firstOf(String a, String b){
		int [] record = new int[26];
		for (char c : b.toCharArray()){
			record[c - 'a'] ++; 
		}
		for (int i = 0; i < a.length(); i++){
			if (record[a.charAt(i) - 'a'] > 0){
				return i;
			}
		}
		return -1;
	}
	
	public static void main (String args[]){
		FirstOf fo = new FirstOf();
		System.out.println(fo.firstOf("abc", "a"));
	}
}
