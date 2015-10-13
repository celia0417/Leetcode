package String;

public class AddBinary {
	public String addBinary(String a, String b) {
        int carry = 0;
        String res = "";
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry > 0; i --, j --){
            int valueA = i >=0 ? a.charAt(i) - '0' : 0;
            int valueB = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = valueA + valueB + carry;
            int digit = sum % 2;
            res = digit + res;
            carry = sum /2;
        }
        return res;
    }
	
	public static void main (String args[]){
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("1111", "1111"))
		;
	}
}
