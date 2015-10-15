package Snapchat;

import java.util.*;

public class The100Game {
	List<Integer> pool;
	int raceTo;
	boolean canWin(int poolMax, int finalSum) {
		/*
		 * If (finalSum > combined sum of all numbers). This is an impossible
		 * problem to solve
		 */
		if (finalSum > ((poolMax * poolMax + poolMax) / 2)) {
			throw new IllegalArgumentException("Expected sum cannot be achieved!");
		}

		raceTo = finalSum;
		pool = new ArrayList<Integer>();
		for (int i = 0; i < poolMax; i++)
			pool.add(i + 1);
		return canIWin();
	}

	/* Autoplay the game with optimal mooves */
	boolean canIWin() {
		int turns = 0;
		while (raceTo > 0) {
			turns++;
            System.out.println("Player"+( (turns%2==0)?"2":"1" )+" ==> "+pickANumber()+"   == Remaining ["+raceTo+"]");

//			pickANumber();
		}
		return (turns % 2 == 1);
	}

	/*
	 * Pick an Optimal number, so to win or prevent he opponent from winning
	 */
	int pickANumber() {
		int leastMax = -1;
		int len = pool.size();
		for (int i = len - 1; i >= 0; i--) {
			int tmp = pool.get(i);
			if (tmp >= raceTo) {
				pool.remove(i);
				raceTo -= tmp;
				return tmp;
			} else {
				if (leastMax > 0) {
					/*
					 * Picking the highest number available in the pool might
					 * let the next player win. So picking a number < leastMax,
					 * if available - to gaurentee otherwise.
					 */
					if (tmp < leastMax) {
						pool.remove(i);
						raceTo -= tmp;
						return tmp;
					} else {
						continue;
					}
				}

				if (i - 1 >= 0) {
					/*
					 * We know, the highest number available in the pool is <
					 * raceTo (target sum) Check in the pool if the sum of the
					 * highest number + nextHighest number >= raceTo (target
					 * sum) [True] => Skip both the numbers and look for a
					 * number < the LeastMax so the opposite player does not
					 * win. [False] => The highest number in the pool is the
					 * best pick
					 */
					if (tmp + pool.get(i - 1) < raceTo) {
						pool.remove(i);
						raceTo -= tmp;
						return tmp;
					} else {
						leastMax = raceTo - tmp;
						i--;
						continue;
					}
				} else {
					pool.remove(i);
					raceTo -= tmp;
					return tmp;
				}
			}
		}

		/*
		 * The raceTo sum cannot be achieved in this turn. There is no number
		 * available in the pool that can prevent a Win in the next turn. So we
		 * return the highest number availble in the pool.
		 */
		int tmp = pool.get(pool.size() - 1);
		pool.remove(pool.size() - 1);
		raceTo -= tmp;
		return tmp;
	}

	public static void main(String[] args) {
		The100Game game = new The100Game();
		System.out.println("\nPlayer-" + (game.canWin(20, 105) ? "1" : "2") + " wins!");
	}
}