package TwoSigma;

import java.util.*;

public class FindMedian {
	private Queue<Integer> minHeap = new PriorityQueue<Integer>();
	private Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

	public void add(int num) {
		if ((minHeap.size() + maxHeap.size() & 1) == 0) {
			if (maxHeap.size() > 0 && num < maxHeap.peek()){
				maxHeap.offer(num);
				num = maxHeap.poll();
			}
			minHeap.offer(num);
		}else{
			if (minHeap.size() > 0 && minHeap.poll() < num){
				minHeap.offer(num);
				num = minHeap.poll();
			}
			maxHeap.offer(num);
		}
	}

	public int findMedian() {
		int size = minHeap.size() + maxHeap.size();
		// if (size == 0)
		// throw new Exception("No numbers are available");
		int median = 0;
		if ((size & 1) == 1)
			median = minHeap.peek();
		else
			median = (minHeap.peek() + maxHeap.peek()) / 2;
		return median;
	}

	int sigNum(int a, int b) {
		if (a == b)
			return 0;
		return a < b ? -1 : 1;
	}

	public static void main(String args[]) {
		FindMedian fm = new FindMedian();
		fm.add(1);
		fm.add(2);
		fm.add(4);
		fm.add(6);
		fm.add(6);
		fm.add(6);
		System.out.println(fm.findMedian());
	}
}
