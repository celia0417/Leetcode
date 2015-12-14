package Google;

import java.util.*;

public class FractionRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num/den);
        num %= den;
        if (num == 0){
            return sb.toString();
        }
        
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while(num != 0){
            num *= 10;
            sb.append(num/den);
            num %= den;
            if (map.containsKey(num)){
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            }else{
                map.put(num,sb.length());
            }
        }
        return sb.toString();
    }
	
	public static void main (String args[]){
		FractionRecurringDecimal frd = new FractionRecurringDecimal();
		System.out.println(frd.fractionToDecimal(1, 5));
	}
}
