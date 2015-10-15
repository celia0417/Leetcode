package Snapchat;

import java.util.*;

public class XMLMap {
	int close;
	String content;
	Map<String, ArrayList<XMLMap>> map;
	
	public XMLMap(){
		close = 1;
	}
	
	void build (XMLMap parent){
		XMLNode node = toknizer.Next();
		String type = node.type;
		String content = node.content;
		if (type == "open"){
			XMLMap child = new XMLMap();
			parent.map.get(content).add(child);
		}
		if (type == "inner"){
			parent.content = content;
		}
		if (type == "close"){
			parent.close--;
		}
	}
	

}
