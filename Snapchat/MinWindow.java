package Snapchat;

import java.util.*;

public class MinWindow {
	public String minWindow(String s, String t) {
        int[] record = new int [256];
        Arrays.fill(record, Integer.MAX_VALUE);
        for (Character c : t.toCharArray()){
            if (record[c] == Integer.MAX_VALUE) record[c] = 1;
            else record[c] ++;
        }
        int n = t.length();
        int cnt = 0, start = 0, min = Integer.MAX_VALUE, minStart = -1;
        for (int i = 0; i < s.length(); i++){
            if (record[s.charAt(i)] != Integer.MAX_VALUE){
                if (record[s.charAt(i)] > 0)
                    cnt ++;
                record[s.charAt(i) ] --;
            }
            while(cnt == n){
                if (record[s.charAt(start)] != Integer.MAX_VALUE){
                    if (record[s.charAt(start)] >= 0){
                       if (i - start + 1 < min){
                        min = i - start + 1;
                        minStart = start;
                        }
                        cnt --;
                    }
                    record[s.charAt(start)]++;
                }
                start++;
            }
        }
        
        return minStart == -1 ? "" :s.substring(minStart, minStart + min);
    }
}
