package LiverRamp;

import java.util.*;

public class FrogJump {
	public int frog(int[] arr, int N, int X, int D) {
		if (X == 0 || D >= X)
			return 0;
		int[] bitmap = new int[X + 1];
		Arrays.fill(bitmap, Integer.MAX_VALUE);
		Map<Integer, Integer> leaf = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!leaf.containsKey(arr[i])) {
				leaf.put(arr[i], i);
			}
		}

		for (int pos = 0; pos <= X; pos++) {
			if (pos <= D)
				bitmap[pos] = 0;
			if (leaf.containsKey(pos)) {
				int step = 1;
				bitmap[pos] = Math.min(bitmap[pos], leaf.get(pos));
				while (pos + step <= X && step <= D) {
					bitmap[pos + step] = Math.min(leaf.get(pos), bitmap[pos + step]);
					step++;
				}
			}
		}
		return bitmap[X] == Integer.MAX_VALUE ? -1 : bitmap[X];

	}

	public static void main(String args[]) {
		FrogJump fj = new FrogJump();
		System.out.println(fj.frog(new int[] { 1, 3, 1, 4, 2, 5 }, 6, 7, 3));
	}
}
