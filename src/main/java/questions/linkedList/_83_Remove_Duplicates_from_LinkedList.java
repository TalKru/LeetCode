package questions.linkedList;


/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:

Input: head = [1,1,2]
Output: [1,2]

Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */
public class _83_Remove_Duplicates_from_LinkedList {

	public static void main(String[] args) {
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		
		n1.next = n2;
		n2.next = n3;
		
		System.out.println("Original linked list:");
		n1.printFromHeadtoTail();
		
		ListNode headResult = deleteDuplicates(n1);
		
		System.out.println("No duplicates linked list:");
		headResult.printFromHeadtoTail();
	}

	
	
	public static ListNode deleteDuplicates(ListNode head) {
		
		if(head == null || head.next == null) return head;
		
		ListNode curr = head;
		
		while(curr.next != null) {
			
			if(curr.val == curr.next.val) {
				
				if(curr.next.next == null) {
					curr.next = null;
					return head;
				}
				else {
					curr.next = curr.next.next;
				}
			}
			else { // no match
				curr = curr.next;
			}
		} // while
		return head;
	}

}



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









