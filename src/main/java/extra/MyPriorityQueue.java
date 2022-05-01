package extra;

import java.util.PriorityQueue;

public class MyPriorityQueue {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(4);
		pq.add(6);
		pq.add(-8);
		pq.add(1);
		pq.add(9);
		pq.add(7);
		pq.add(0);
		
		while(!pq.isEmpty()) {
			
			System.out.println(pq.peek() + ", " +   pq.poll());
			
		}

	}

}
