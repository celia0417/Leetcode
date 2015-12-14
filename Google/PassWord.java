package Google;
import java.util.*;

public class PassWord {
	public static String getPass(HashSet<Integer> visit) {
		int num = 0000;
		int count = 0;
		StringBuilder sb = new StringBuilder("000");
		while (visit.size() < 10000) {
			sb.append(num % 10);
			visit.add(num);
			num *= 10;
			num %= 10000;
			int add = 0;
			while (add < 9) {
				if (!visit.contains(num + add)) {
					break;
				}
				add++;
			}
			num += (add % 10);
			count++;
		}
		System.out.println(count);
		return sb.toString();
	}
	
	public static String getPass2(HashSet<Integer> visit) {
		int num = 0;
		int count = 0;
		StringBuilder sb = new StringBuilder();
		dfs(num, count, sb);
		return sb.toString();
	}
	
	public static void dfs(int num, int count, StringBuilder sb){
		if (count == 4) return;
		for (int i = 0; i < 10; i++){
			sb.append(i);
			dfs(num, count + 1, sb);
		}
	}

	public static void main(String[] args) {
		HashSet<Integer> visited = new HashSet<Integer>(0);
		String s = getPass(visited);
		System.out.println(s);
		System.out.println("length:" + s.length());
//		for (int i = 0; i < 10000; i++) {
//			String num = Integer.toString(i);
//			// refill the string, e.g:39->0039
//			if (num.length() < 4) {
//				StringBuilder sb = new StringBuilder(num);
//				for (int j = 0; j < 4 - num.length(); j++) {
//					sb.insert(0, "0");
//				}
//				num = sb.toString();
//			}
//			if (s.indexOf(num) == -1) {
//				System.out.println("false");
//			}
//		}
	}
}
