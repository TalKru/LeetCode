package questions.linkedList;


/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, 
and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, 
except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class _2_Add_Two_Numbers_LinkedList {

	public static void main(String[] args) {

		// n = 124957
		ListNode n1 = new ListNode(7); // head == LSB
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(9);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(1); // tail == MSB
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		// m = 900153
		ListNode m1 = new ListNode(3); // head == LSB
		ListNode m2 = new ListNode(5);
		ListNode m3 = new ListNode(1);
		ListNode m4 = new ListNode(0);
		ListNode m5 = new ListNode(0);
		ListNode m6 = new ListNode(9); // tail == MSB
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = m5;
		m5.next = m6;
		// Sum = 124957 + 900153 = 1,025,110

		System.out.print("Number n = " + extractIntfromList(n1) + "\n");
		n1.printFromHeadtoTail();

		System.out.println();

		System.out.print("Number m = " + extractIntfromList(m1) + "\n");
		m1.printFromHeadtoTail();

		System.out.println();

		System.out.println("Sum = " + (extractIntfromList(n1) + extractIntfromList(m1)));

		ListNode resultHead = addTwoNumbers(n1, m1);
		resultHead.printFromHeadtoTail();

	} // main



	// Legit solution, as long the lists holding numbers 
	// which can be contained by 'long' var
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	    	if(l1 == null || l2 == null) return null;
	    	
	    	// add the two numbers as Ints
	    	long sum = extractIntfromList(l1) + extractIntfromList(l2);
	    	
	    	// create new list representation for the addition
	    	ListNode newHead = new ListNode();
	    	ListNode curr = newHead;
	    	
	    	while(sum != 0) {
	    		
	    		curr.val = (int)(sum % 10);
	    		sum /= 10;
	    		
	    		if(sum != 0) {   // no need so assign new node if the number is complete
	    			curr.next = new ListNode();
	    			curr = curr.next;
	    		}
	    	}
	    	return newHead;
	    }

	public static long extractIntfromList(ListNode head) {

		long res = 0;
		int pow = 0;

		while(head != null) {

			res += (head.val * Math.pow(10, pow));
			pow++;
			head = head.next;
		}
		return res;
	}

	
    //This list node uses for optimize memory usage
//    private static final ListNode ZERO_NODE = new ListNode(0);
//
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return recursiveSum(l1, l2, 0);
//    }
//
//    /**
//	 * Calculate sum of node values recursively
//	 *
//	 * @param a     first node
//	 * @param b     second node
//	 * @param carry the number from the last addition
//	 * @return calculated list node
//	 */
//    public static ListNode recursiveSum(ListNode a, ListNode b, int carry) {
//        int sum = (a.val + b.val) + carry;
//        int newCarry = sum / 10;
//
//        ListNode r = new ListNode(sum % 10);
//        if (a.next == null && b.next == null) {
//            if (newCarry > 0) {
//                r.next = new ListNode(newCarry);
//            }
//        } else {
//            r.next = recursiveSum(
//                    (a.next == null) ? ZERO_NODE : a.next,
//                    (b.next == null) ? ZERO_NODE : b.next, newCarry);
//        }
//        return r;
//    }    
	 
}



















