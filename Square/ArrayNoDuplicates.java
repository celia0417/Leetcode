package Square;

public class ArrayNoDuplicates {
	
	public static final int hash(int a) {         
	      a ^= (a << 13);
	      a ^= (a >>> 17);        
	      a ^= (a << 5);
	      return a;   
	}
}
