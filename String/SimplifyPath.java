package String;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String> ();
        String res = "";
        String singlePath [] = path.split("/");
        for (int i = 0; i < singlePath.length; i ++){
        	switch (singlePath[i]){
        		case ".." : 
        		if (!stack.isEmpty()){
        			stack.pop();
        		}
        		case ".": break;
        		case "" : break;
        		default : stack.push(singlePath[i]);
        		
        	}
        }
        if (stack.isEmpty()) return "/";
        for (String s : stack){
        	res += "/" + s;
        }
        return res;
    }
	
	public static void main (String args[]){
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/abc/..."));
	}
}
