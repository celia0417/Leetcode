package Google;

public class Number1Bits {
	public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0){
            if ((n & 1) == 1) cnt ++;
            n >>>= 1;
        }
        return cnt;
    }
	
	public static void main (String args[]){
		Number1Bits nb = new Number1Bits();
		System.out.println(nb.hammingWeight(-3));
	}
}
