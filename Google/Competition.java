package Google;

public class Competition {
	static String match(int t1, int t2){
		return "(" + t1 + ","+t2 + ")";	
	}
	
	public static void main (String args[]){
		int n = 8;
		String res= "";
		while (n  > 1){
			for (int i = 1; i <= n/2; i ++){
				res+= match(i, n- i+1);
			}
			n/=2;
		}
		System.out.println(res);
	}
}
