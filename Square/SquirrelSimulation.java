package Square;

import java.util.*;

public class SquirrelSimulation {

	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
       Scanner scanner = new Scanner(System.in);
        long[] squirrel = new long[2];
        squirrel[0] = scanner.nextLong();
        squirrel[1] = scanner.nextLong();
        
        long[] tree = new long[2];
        
        tree[0] = (long)scanner.nextDouble();
        tree[1] = (long)scanner.nextDouble();

        int n = scanner.nextInt();
        final long[][] nuts = new long[n][2];
        for (int i = 0; i < n; i ++) {
            nuts[i][0] = (long)scanner.nextDouble();
            nuts[i][1] = (long)scanner.nextDouble();
        }
        
        
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return nuts[n1][0] == nuts[n2][0] ? (int)(nuts[n1][1] - nuts[n2][1]) : (int)(nuts[n1][0] - nuts[n2][0]);
            }
        };
        
        long res = 0;
        
        long minDis = Long.MAX_VALUE;
        int minIndex = 0;
        
        if (n == 0) {
            System.out.println(0);
            return;
        }
            
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i ++) {
            long dis = Math.abs(squirrel[0] - nuts[i][0]) + Math.abs(squirrel[1] - nuts[i][1]);
            if (dis < minDis) {
                minDis = dis;
                list.clear();
                list.add(i);
            } else if (dis == minDis) {
                list.add(i);
            }
            res += Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]);
        }

        Collections.sort(list, comparator);
        res *= 2;
        res += minDis - Math.abs(tree[0] - nuts[list.get(0)][0]) - Math.abs(tree[1] - nuts[list.get(0)][1]);

        System.out.println(res);
    }
}
