package questions.linkedList;


/*
Given the head of a linked list and an integer val, 
remove all the nodes of the linked list that has Node.val == val, 
and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input: head = [], val = 1
Output: []

Example 3:
Input: head = [7,7,7,7], val = 7
Output: []

Constraints:
The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
 */
public class _203_Remove_LinkedList_Elements {

	public static void main(String[] args) {

		ListNode n1 = new ListNode(777);
		ListNode n2 = new ListNode(777);
		ListNode n3 = new ListNode(777);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(777);
		ListNode n6 = new ListNode(777);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n1.printFromHeadtoTail();

		ListNode updated = removeElements(n1, 777);

		if(updated != null) {
			updated.printFromHeadtoTail();
		}
	}


	
	public static ListNode removeElements(ListNode head, int val) {

		if(head == null) return head;

		ListNode curr = head;

		while(curr != null) {

			// case: first node removal
			if(head.val == val) {
				head = head.next;
				curr = head;
			}
			else if(curr != null && curr.next!= null && curr.next.val == val) {

				ListNode longRun = curr.next.next;

				while(longRun != null && longRun.val == val) {
					longRun = longRun.next;
				}
				curr.next = longRun;
				curr = longRun;
			}
			else {
				curr = curr.next;
			}
		}
		return head;
	}
}
