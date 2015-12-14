package TwoSigma;

public class PowerFour {
	public boolean powerFour(int n){
		while (n > 0){
			n >>= 2;
			if ((n & 1) == 1) return true;
		}
		return false;
	}
	
	public static void main (String args[]){
		PowerFour pf = new PowerFour();
		System.out.println(pf.powerFour(32));
	}
}
