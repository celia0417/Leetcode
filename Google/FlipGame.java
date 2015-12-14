package Google;

public class FlipGame {
	public boolean canWin(String s) {
        for (int i = 1; i < s.length(); i++){
            char[] arr = s.toCharArray();
            if (arr[i] == '+' && arr[i-1] == '+'){
                arr[i] = arr[i-1] ='-';
                if (!canWin(new String(arr))){
                    return true;
                }
                arr[i] = arr[i-1] = '+';
            }
        }
        return false;
    }
	
	public static void main (String args[]){
		FlipGame fg = new FlipGame();
		System.out.println(fg.canWin("+++++"));
	}
}
