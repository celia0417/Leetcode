package HashTable;
import java.util.*;
public class ValidWordAbbr {
	Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
    public ValidWordAbbr(String[] dictionary) {
         for (int i = 0; i < dictionary.length; i++){
            int n = dictionary[i].length();
            if (n <= 2) map.put(dictionary[i], new HashSet<String>(Arrays.asList(dictionary[i])));
            String abbr = dictionary[i].charAt(0) + String.valueOf(n-2) + dictionary[i].charAt(n-1);
            if (map.containsKey(abbr)){
                map.get(abbr).add(dictionary[i]);
            }else{
                map.put(abbr, new HashSet<String>(Arrays.asList(dictionary[i])));
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = word.charAt(0) + String.valueOf(word.length()-2) + word.charAt(word.length() - 1);
        return (!map.containsKey(word) && (!map.containsKey(abbr))) || (map.containsKey(abbr) && map.get(abbr).size() ==1 && map.get(abbr).contains(word));
    }
    
    public static void main(String args[]){
    	ValidWordAbbr vwa = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
    	System.out.println(vwa.isUnique("cake"));
    }
}
