package Google;
import java.util.*;
public class StreamMean {
	Deque<Double> deque = new LinkedList<>();
	double mean = 0.0;
	int count = 0;
	public double read(double a, int size){
		if (count < size){
			deque.add(a);
			mean = (mean * count + a) / (count +1);
			count ++;
		}else {
			deque.add(a);
			mean = (mean * count - deque.peekFirst() + a) / size;			
		}
		return mean;
	}
	
	private int max = 0;
	private Deque<Character> d = new LinkedList<>();
	private int window [] = new int [256];
	private int duplicateCnt = 0;
	
	public int largestSubstring (String x, int n){
		for (int i = 0; i < x.length(); i++){
			
		}
		return max;
	}
	
	public static void main (String args[]){
		StreamMean sm = new StreamMean();
		System.out.println(sm.read(2.0, 2));
		System.out.println(sm.read(3.0, 2));
		System.out.println(sm.read(4.0, 2));
	}
}
