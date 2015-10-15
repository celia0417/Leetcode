package Snapchat;

import java.util.*;

import Snapchat.BF.HashFunction;

public class BF2 {
	private int thres;
	private int len;
	private int cur;
	private List<Boolean[]> data;
	private List<HashFunction> hash;

	public BF2(int len, List<HashFunction> hash, int thres) {
		this.len = len;
		this.data = new ArrayList<Boolean[]>();
		this.hash = hash;
		this.thres = thres;
		this.cur = 0;
	}
	
	void add(String s){
		if (cur >= thres){
			Boolean [] bol = new Boolean[len];
			Arrays.fill(bol, false);
			data.add(bol);
			cur = 0;
		}
		Boolean[] d = data.get(data.size()-1);
		for (HashFunction h : hash){
			if (!d[h(s) % len]){
				d[h(s) % len] = true;
				cur++;
			}
		}
	}
	
	boolean mightContain(String s, Boolean[] data){
		for (HashFunction h : hash){
			if(!data[h(s) % len]){
				return false;
			}
		}
		return true;
	}
	
	boolean mightContain(String s){
		for (Boolean[] d : data){
			if(mightContain(s, d)){
				return true;
			}
		}
		return false;
	}
}
