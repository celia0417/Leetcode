package String;

public class CountAndSay {
	public String countAndSay(int n) {
		String pre = "", cur = "1";
		if (n == 1) return cur.toString();
		int N =1;
		while (N < n){
			pre = cur;
			cur = "";
			char say = pre.charAt(0);
			int cnt = 1;
			for (int i = 1; i < pre.length(); i++){
				if (pre.charAt(i) == say){
					cnt ++;
				}else{
					cur += Integer.toString(cnt) + say;
					cnt =1; 
					say = pre.charAt(i);
				}
			}
			cur = cur +cnt + say;
			N++;
		}
        return cur; 
    }
	
	public static void main(String args[]){
		CountAndSay cas = new CountAndSay();
		System.out.println(cas.countAndSay(2));
	}
}
