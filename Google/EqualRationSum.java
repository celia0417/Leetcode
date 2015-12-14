package Google;

public class EqualRationSum {
	public double equalRatio(double x, int n){
		return (pow(x, n+ 1) - 1) / (n - 1);
	}
	
	public double pow(double x, int n){
		if (n == 0) return 1.0;
		if (n < 0){
			x = 1.0 / x;
			n = -n;
		}
		if (n % 2 == 0) return pow (x * x, n /2);
		else return pow (x * x, n / 2) * x; 
	}
}
