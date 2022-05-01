package questions.linkedList;


/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list 
that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. 
Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.


Constraints:
The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class _141_Linked_List_Cycle {

	public static void main(String[] args) {

		ListNode n1 = new ListNode(3); // head node
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(-4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2; // loop!

		boolean res = hasCycle(n1);

		System.out.println("Linked Lisr has cicle: " + res);

	} // main


	/* Here we have a fast pointer and a slow pointer. 
	 We keep the fast pointer ahead of slow pointer by one node always. 
	 In while loop we check if fast pointer is not reaching null then , 
	 if fast and slow are at same node, we return true. 
	 If there is a cycle, the fast pointer will eventually meet with the slow pointer.
	 If not then we return -1;
	 If the length of the cycle is M, after M iterations, the fast pointer will definitely move one more cycle and catch up with the slow pointer. 
	 */
	public static boolean hasCycle(ListNode head) {

		if(head == null || head.next == null) { return false; }

		ListNode slow = head;
		ListNode fast = head.next;

		while(fast.next != null) {

			if(slow == fast) { return true; } // Collision!

			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}


	/* simple solution, saves in HashSet every visited node and checks if seen it before */
	//	public static boolean hasCycle(ListNode head) {
	//
	//		if(head == null || head.next == null) { return false; }
	//	
	//		ListNode curr = head;
	//		HashSet<ListNode> visited = new HashSet<>();
	//
	//		while(curr.next != null) {
	//			//System.out.println(curr.val);
	//
	//			if(visited.contains(curr)) {
	//				return true;
	//			}
	//			visited.add(curr);
	//			curr = curr.next;
	//		}
	//		return false;
	//	}

} // class














