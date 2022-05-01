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
		// TODO Auto-generated method stub

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


























