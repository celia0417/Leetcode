package Bloomberg;

public class AlphabeticalOrder {
	public void printAlphabetical(String str) {
		int[] c = new int[26];
		for (int i = 0; i < str.length(); i++){
			c[str.charAt(i) - 'a'] ++;
		}
		for (int i = 0; i < c.length; i++){
			System.out.println((char) (i + 'a') +" :"+ c[i]);
		}
	}
	
	public static void main (String args[]){
		AlphabeticalOrder ao = new AlphabeticalOrder();
		ao.printAlphabetical("dghlrbydghye");
	}
}
