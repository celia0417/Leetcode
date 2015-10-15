package Snapchat;


import java.util.*;

public class BF{
	List<Boolean[]> list;
	List<Integer> size;
	Set<HashFunction> hashFunctions;
	int curSize;

	public BF(int n, Set<HashFunction> hashFunctions){
		Boolean[] set = new Boolean[n];
		list = new ArrayList<Boolean[]>();
		list.add(set);
		size = new ArrayList<Integer>();
		size.add(n);
		this.hashFunctions = hashFunctions;
		this.curSize = n;
	}

	void add(String element){

		if (shouldExpand()) {
			Boolean[] set = new Boolean[curSize];// TODO: expand
			list.add(set);
			size.add(curSize);
			curSize *= 2;
		}

		for(HashFunction hf: hashFunctions){
			setPosition(hf.get(element));
		}
	}
	
	boolean shouldExpand(){
		return true;
	}
	
	void extend(){
		
	}
	
	void setPosition(int hashValue) {
		int count = 0;
		for(int i = 0 ; i < size.size(); i++) {
			int len = size.get(i);
			count += len;
			list.get(i)[hashValue % count] = true;
		}
	}

	boolean contains(String element){
		for(HashFunction hf: hashFunctions){
			if(!set[hf.get(element) % curSize]){///   & list of lengths 100 200 400 800
				return false;
			}
		}
		return true;
	}
	
	public class HashFunction{
		public HashFunction(String element){
			
		}
		public int get(String str){
			return Integer.parseInt(str);
		}
	}
}
