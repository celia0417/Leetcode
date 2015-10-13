package TopologicalSort;

import java.util.*;

public class FriendCircles {
//	static LinkedList<Integer> queue = new LinkedList<Integer>();
//
//	static int friendCircles(String[] friends) {
//		int cnt = 0;
//		for (int j = 0; j < friends.length; j++) {
//			if (friends[j].contains("Y")) {
//				cnt++;
//				friends[j] = helper(friends[j]);
//				while (!queue.isEmpty()) {
//					int head = queue.poll();
//					friends[head] = helper(friends[head]);
//				}
//			}
//		}
//		return cnt;
//	}
//
//	static String helper(String row) {
////		int index;
////		while ((index = row.indexOf('Y')) != -1) {
////			queue.add(index);
////			row = row.replaceFirst("Y", "N");
////		}
////		return row;
//		while(row.contains("Y")){
//			int i = row.indexOf('Y');
//			queue.add(i);
//			row = row.replaceFirst("Y", "#");
//		}	
//		return row;
//	}
	
	static LinkedList<Integer> queue = new LinkedList<Integer>();
    static int friendCircles(String[] friends) {
        int count = 0 ;
        for (int j = 0; j < friends.length; j++){
            if (friends[j].contains("Y")){
                count ++;
                friends[j] = helper(friends[j]);
                while (!queue.isEmpty()){
                    int cur = queue.poll();
                    friends[cur] = helper(friends[cur]);
                }
            }
        }
        return count;
    }

    static String helper(String row){
        while(row.contains("Y")){
            int i = row.indexOf("Y");
            queue.offer(i);
            row = row.replaceFirst("Y", "#");
        }
        return row;
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numFriends = Integer.parseInt(scanner.nextLine());
		String[] friends = new String[numFriends];
		for (int i = 0; i < numFriends; i++) {
			friends[i] = scanner.nextLine();
		}
		System.out.println(friendCircles(friends));
	}
}
