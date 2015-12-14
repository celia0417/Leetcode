package Square;

public class ReverseBitsInteger {
	public int reverseBits(int n) {
        int res = 0; 
        for (int i = 0; i < 32; i++){
            res += n & 1;
            n >>>= 1;
            if (i < 31)
                res <<= 1;
        }
        return res;
    }

	public static void main(String args[]) {
		ReverseBitsInteger rb = new ReverseBitsInteger();
		System.out.println(rb.reverseBits(10));
	}
}
