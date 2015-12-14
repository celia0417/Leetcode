package Zenefits;

import java.util.*;

public class VerifyPreorder {
	public static boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<int[]> list = new ArrayList<>(); 
		int total = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < total; i++) {
			int n = Integer.parseInt(scanner.nextLine());

			int[] preorder = new int[n];
			String input = scanner.nextLine();
			String[] arr = input.split(" ");
			for (int j= 0 ; j < n; j++){
				preorder[j] = Integer.parseInt(arr[j]);
				System.out.println(verifyPreorder(preorder));
			}
		}
	}
}
