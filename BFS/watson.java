package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class watson {
	public static void main(String[] args) throws IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    while ((s = in.readLine()) != null) {
	        System.out.println(s);
	    }
	    String input [] = s.split(" ");
	    int N = Integer.parseInt(input[0]);
	    int p = Integer.parseInt(input[1]);
	    int q = Integer.parseInt(input[2]);
	    for (int i = 1; i <= N; i++){
	        if (i % p == 0 && i % q == 0){
	            System.out.println("WATSON");
	        }else if (i % p == 0){
	            System.out.println ("WAT");
	        }else if (i % q == 0){
	            System.out.println("SON");
	        }else{
	            System.out.println(i);
	        }
	    }
	  }
}
