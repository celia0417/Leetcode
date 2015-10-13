
import java.util.*;

public class List {
	public static void main(String args[]) {
//		ArrayList<String> list = new ArrayList<String>(Arrays.asList("bad", "bad","good"));
//		if (list != null) {
//			for (Iterator itr = list.iterator(); itr.hasNext();) {
//				if ("bad".equals(itr.next()))
//					itr.remove();
//			}
//		}
//		for (String s : list) {
//			System.out.println(s);
//		}
//
//		if (list != null) {
//			for (int i = 0; i < list.size(); i++) {
//				if ("bad".equals(list.get(i))) {
//					list.remove(i);
//				}
//			}
//		}
//		for (String s : list) {
//			System.out.println(s);
//		}
	
	
	for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {

        if (b == 0x90) {

            System.out.print("We found it");

         }

    }
	
    ArrayList<Integer> list = new ArrayList<Integer>();

    Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);

    final Integer pos = Integer.valueOf(3);

    list.remove(pos);

    System.out.println(list);
	}
}
