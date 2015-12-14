package Google;

import java.util.Arrays;

public class PlusOne2 {
    public String plusOne(String digits) {
    	if (digits.charAt(0) == '-') {
        	digits = digits.substring(1);

    		char[] digit = digits.toCharArray();
    		int i;
        	for (i = digit.length - 1; i >=0; i-- ){
        		if (digit[i] == '0') digit[i] = '9';
        		else {
        			int x = digit[i] - '0' - 1;
        			digit[i] = Character.forDigit(x, 10);
        			String ret = new String(digit);
        			if (i == 0 && digit[i] == '0') ret = ret.substring(1);
        			return "-"+ret;
        		}
        	}
        	return "";

    	}else{
    		char[] digit = digits.toCharArray();
        	for (int i = digit.length - 1; i >=0; i-- ){
        		if (digit[i] == '9') digit[i] = '0';
        		else {
        			int x = digit[i] - '0' + 1;
        			digit[i] = Character.forDigit(x, 10);
        			String ret = new String(digit);
        			return ret;
        		}
        	}
        	char[] res = new char[digits.length() + 1];
        	Arrays.fill(res, '0');
        	res[0] = 1;
        	String ret = new String(res);
        	return ret;	
    	}
    }
    
    public static void main (String args[]){
    	PlusOne2 po = new PlusOne2();
    	System.out.println(po.plusOne("-9800"));
    }
}
