package HashTable;
import java.util.*;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if (strArray.length != pattern.length()) return false; 
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++){
            if (map.containsKey(pattern.charAt(i))){
                if (!map.get(pattern.charAt(i)).equals(strArray[i]))
                    return false;
            }else if (map.containsValue(strArray[i])){
                return false;
            }
            map.put(pattern.charAt(i), strArray[i]);
        }
        return true;
    }
	
	public static void main (String args[]){
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("jquery", "jquery"));
	}
}
