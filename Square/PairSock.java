package Square;

import java.util.*;

public class PairSock {
	private class Sock{
		String pair;
		int id;
		String color;
		Sock (){
			
		}
	}
	
	public List<int []> socks(List<Sock> list){
		Stack<Sock> left = new Stack<>();
		Stack<Sock> right = new Stack<>();
		List<int []> res= new ArrayList<>();
		for (Sock sock : list){
			if (sock.pair.equals("left")){
				if (!right.isEmpty()) res.add(new int [] {sock.id, right.pop().id}); 
				else
					right.add(sock);
			}else if (sock.pair.equals("right")){
				if (!left.isEmpty()) res.add(new int [] {left.pop().id, sock.id});
				else left.add(sock);
			}
		}
		return res;
	}
	
	public List<int []> sortByColor(List<Sock> list){
		List<int []> res= new ArrayList<>();
		Map<String, List<Sock>> map = new HashMap<>();
		for (Sock sock : list){
			String color = sock.color;
			String p = sock.pair;
			String key = color + "," + p;
			String pair = sock.pair == "left" ? "right":"left";
			String lookup = color + "," + pair;
			if (map.containsKey(lookup)){
				Sock s = map.get(lookup).remove(0);
				res.add(new int [] {s.id, sock.id});
			}else if (map.containsKey(key)){
				map.get(key).add(sock);
			}else {
				map.put(key, new ArrayList<Sock>(Arrays.asList(sock)));
			}
		}
		return res;
	} 
}
