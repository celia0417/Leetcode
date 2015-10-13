package FB;

public class PalindromePartition {
    public int partition(String s) {
    	int cnt = 0;
    	for (int i = 0; i < s.length(); i++) cnt ++;
    	for (int i = 1; i < s.length(); i++) {
    		//even
    		for (int l = i -1, r = i; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++){
    			cnt ++;
    		}
    		//odd
    		for (int l = i -1, r = i+1; l >= 0 && r< s.length() && s.charAt(l) == s.charAt(r); l--, r++){
    			cnt ++;
    		}
    	}
    	return cnt;
    }
    
    public static void main (String args[]){
    	PalindromePartition pp = new PalindromePartition();
    	System.out.println(pp.partition("abba"));
    }
}
