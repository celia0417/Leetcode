package Math;

import java.util.*;

public class FindStrobogrammatic {
	public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        for (int i = (int) Math.pow(10,n-1); i < (int) Math.pow(10, n); i++){
            String str = Integer.toString(i);
            boolean flag = true;
            for (int j = 0, z = str.length() - 1; j <= z; j ++, z --){
                if (!"696 88 11 00".contains(str.charAt(j) + "" + str.charAt(z))){
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(str);
        }
        return res;
    }
	
	public static void main(String args[]){
		FindStrobogrammatic fs = new FindStrobogrammatic();
		List<String> res = fs.findStrobogrammatic(8);
		for (String str : res){
			System.out.println(str);
		}
	}
}
