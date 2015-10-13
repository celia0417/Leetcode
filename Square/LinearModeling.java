package Square;

import java.util.Scanner;
import java.util.*;

public class LinearModeling {
	public static void main (String args[]){
		Scanner scanner = new Scanner(System.in);
		String co[] = scanner.nextLine().split(",");
		List<String []> transactions = new ArrayList<>();
		
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			transactions.add(line.split(","));
		}
		List<String> res = new ArrayList<>();
		for (String [] transaction : transactions){
			float sum = Float.parseFloat(co[0]);
			for (int i = 0; i < transaction.length; i++){
				sum += Float.parseFloat(transaction[i]) * Float.parseFloat(co[i+1]);
			}
			if (sum < 0.0){
				res.add("not fraud");
			}else{
				res.add("suspect fraud");
			}
		}
		
		for (String r : res){
			System.out.println(r);
		}
	}
}
