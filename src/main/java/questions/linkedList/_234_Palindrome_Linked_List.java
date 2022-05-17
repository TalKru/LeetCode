package questions.linkedList;

import java.util.Stack;


/*
Given the head of a singly linked list, return true if it is a palindrome.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false
 
Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 
Follow up: Could you do it in O(n) time and O(1) space?
 */
public class _234_Palindrome_Linked_List {

	public static void main(String[] args) {

		/*************(LinkedList)*************/
		ListNode n1 = new ListNode(47); // root
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(1);
		ListNode n7 = new ListNode(47);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n1.printFromHeadtoTail();
		/*************(LinkedList)*************/

		System.out.println("LinkedList is Palindrome? ");
		System.out.println(isPalindrome(n1));
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
	
	// O(n) time, O(n) space
	public static boolean isPalindrome(ListNode head) {
		
		ListNode curr = head;
		
		Stack<Integer> stack = new Stack<>();
		
		while(curr != null) {
			stack.push(curr.val);
			curr = curr.next;
		}
		curr = head; // reset traversal
		
		while(!stack.isEmpty()) {
			
			if(curr.val != stack.peek()) {
				return false;
			}
			curr = curr.next;
			stack.pop();
		}
		return true;
	}
}


























