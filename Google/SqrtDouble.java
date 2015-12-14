package Google;

import java.util.HashMap;
import java.util.Map;

public class SqrtDouble {
	public double mySqrt(double fg) {
		double n = fg / 2.0;
		double lstX = 0.0;
		while (n != lstX) {
			lstX = n;
			n = (n + fg / n) / 2.0;
		}
		return n;
	}

	float sqrt11(float number, int p) {
		double ACCURACY = 1.0 / Math.pow(10.0, (double) p);
		float lower, upper, guess;
		if (number < 1) {
			lower = number;
			upper = 1;
		} else {
			lower = 1;
			upper = number;
		}

		while ((upper - lower) > ACCURACY) {
			guess = (lower + upper) / 2;
			if (guess > number / guess)
				upper = guess;
			else
				lower = guess;
		}
		Map<String,Integer> map = new HashMap<>();
		map.hashCode();
		return (lower + upper) / 2;
	}

	public static void main(String args[]) {
		SqrtDouble sd = new SqrtDouble();
		System.out.println(sd.mySqrt(2));
		System.out.println(sd.sqrt11(2, 1));
	}
}
