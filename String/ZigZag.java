package String;

public class ZigZag {
	public String convert(String s, int numRows) {
		StringBuffer res = new StringBuffer();
		if (numRows <= 1) return s;
		int cycle = 2*numRows-2;
		for (int row = 0; row < numRows; row ++){
			for (int j = row; j < s.length(); j = j + cycle){
				res.append(s.charAt(j));
				int second = (j - row ) + cycle - row;
				if (row != 0 && row != numRows-1 && second < s.length()){
					res.append(s.charAt(second));
				}
			}
		}
        return res.toString();
    }
	
	public static void main(String args[]){
		ZigZag zz = new ZigZag();
		System.out.println(zz.convert("abcdefg", 3));
	}
}
