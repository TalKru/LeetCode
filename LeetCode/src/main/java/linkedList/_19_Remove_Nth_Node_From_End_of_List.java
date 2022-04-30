package linkedList;


/*
Given the head of a linked list, 
remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _19_Remove_Nth_Node_From_End_of_List {

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		System.out.println("Before: ");
		n1.printFromHeadtoTail();
		
		int removeNodeLocation = 2;
		System.out.println("remove Node Location from the TAIL: " + removeNodeLocation);
		
		
		ListNode result = removeNthFromEnd(n1, removeNodeLocation);
		
		System.out.println("After: ");
		result.printFromHeadtoTail();
	}

	// O(2n)
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode currNode = head;
		int size = 0;
		
		while(currNode != null) {
			size++;
			currNode = currNode.next;
		}
		// first node (head) removal case
		if(n == size) {
			head = head.next;
			return head;
		}
		currNode = head; // reset pointer
		
		for (int i = 1; i <=  size - n - 1; i++) {
			currNode = currNode.next;
		}
		// need to remove (5)
		// you are here:   ->(4)<- currNode
		// (1)-->(2)-->(3)-->(4)-->(5)-->(7)-->null
		
		// remove last node case
		// (1)-->(2)-->(3)-->
		//     ->(2)<- (X)
		// (3) Should be removed
		if(currNode.next.next == null) { 
			currNode.next = null;
			return head;
		}
		// non-last node removal case
		currNode.next = currNode.next.next;
		return head;
	}
	
	
	// O(n)
	public ListNode removeNthFromEnd2(ListNode head, int n) {
	    
	    ListNode start = new ListNode(0);
	    ListNode slow = start; 
	    ListNode fast = start;
	    start.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i = 1; i <= n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
}


















