package linkedList;


/*
Given the head of a singly linked list, 
reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class _206_Reverse_LinkedList {

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
		n1.printFromHeadtoTail();

		ListNode updated = reverseList(n1);

		if(updated != null) {
			updated.printFromHeadtoTail();
		}
	}
	
	
	
	public static ListNode reverseList(ListNode head) {
		
		if(head == null) return head;
		if(head.next == null) return head;
		if(head.next.next == null) {
			ListNode newHead = head.next;
			newHead.next = head;
			head.next = null;
			return newHead;
		}
		// at least 3 nodes exist from this point
		
		ListNode a = head;
		ListNode b = head.next;
		ListNode c = head.next.next;
		
		a.next = null; // head is now tail   null<-(a)  (?)->(?)->null
		
		while(c != null) {
			b.next = a;
			a = b;
			b = c;
			c = c.next;
		}
		
		// (?)<-(?)<-...(a)->(b)->[c/null] 
		b.next = a;
		return b; 
	}
	
}

















