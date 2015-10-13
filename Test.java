import java.util.Scanner;

public class Test {
	public void print(int n) {
		for (int i = 1; i <= n; i++) {
			for (int p = 1; p <= n - i; p++){
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner scanner = new Scanner(System.in);
		int numStr = Integer.parseInt(scanner.nextLine());
		Test sol = new Test();
		sol.print(numStr);
	}
}
