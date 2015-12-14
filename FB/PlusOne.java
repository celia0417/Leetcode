package FB;

public class PlusOne {
	public int add(int a, int b){  
        while (b != 0){
            int carry = (a & b) ;

            a = a ^ b; 

            b = carry << 1;
        }
        return a;
 }
	public static void main(String args[]){
		PlusOne po = new PlusOne();
		System.out.println(po.add(20, 1));
	}
}
