package Bloomberg;

import java.util.Arrays;
import java.util.Vector;

public class VectorAddition {
	public Vector<Integer> vectorAddition(Vector<Integer> v1, Vector<Integer> v2) {
		int carry = 0;
		Vector<Integer> v = new Vector<>();
		for (int i = v1.size() - 1, j = v2.size() - 1; i >= 0 || j >= 0; i--, j--) {
			int val1 = i >= 0 ? v1.get(i) : 0;
			int val2 = j >= 0 ? v2.get(j) : 0;
			int sum = val1 + val2 + carry;
			v.add(0, sum % 10);
			carry = sum / 10;
		}
		return v;
	}

	public Vector<Integer> vectorMultiply(Vector<Integer> v1, Vector<Integer> v2) {
		Vector<Integer> v = new Vector<Integer>();
		int carry = 0;
		int num[] = new int[v1.size() + v2.size()];
		for (int i = v1.size() - 1; i >= 0; i--) {
			int value1 = i >= 0 ? v1.get(i)  : 0;
			int k = v2.size() + i;
			for (int j = v2.size() - 1; j >= 0 || carry > 0; j--) {
				int value2 = j >= 0 ? v2.get(j)  : 0;
				int multiplication = value1 * value2 + num[k] + carry;
				num[k] = multiplication % 10;
				carry = multiplication / 10;
				k--;
			}
		}
		for (int i : num){
			v.add(i);
		}
		return v;
	}

	public static void main(String args[]) {
		VectorAddition va = new VectorAddition();
		Vector<Integer> res = va.vectorMultiply(new Vector<Integer>(Arrays.asList(1, 2, 7)),
				new Vector<Integer>(Arrays.asList(2, 3, 4, 6)));
		for (int i : res) {
			System.out.println(i);
		}
	}
}
