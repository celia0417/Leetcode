package String;

import java.util.*;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strings){
            int offset = (s.charAt(0) - 'a') % 26;
            String str = "";
            for (int i = 0; i < s.length(); i++){
            	char temp = (char) (s.charAt(i) - offset);
            	str += temp;
            }
            if (!map.containsKey(str)){
            	List<String> list = new ArrayList<>();
            	list.add(str);
            	map.put(str, list);
            }else{
            	map.get(str).add(s);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
        	Collections.sort(entry.getValue());
        	res.add(entry.getValue());
        }
        return res;
    }
}
