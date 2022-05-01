package questions.linkedList;


/*
Write a function to delete a node in a singly-linked list. 
You will not be given access to the head of the list, 
instead you will be given access to the node to be deleted directly.
It is guaranteed that the node to be deleted is not a tail node in the list.


Example 1:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, 
the linked list should become 4 -> 1 -> 9 after calling your function.

Example 2:
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, 
the linked list should become 4 -> 5 -> 9 after calling your function.


Constraints:
The number of the nodes in the given list is in the range [2, 1000].
-1000 <= Node.val <= 1000
The value of each node in the list is unique.
The node to be deleted is in the list and is not a tail node
 */
public class _237_Delete_Node_in_a_Linked_List {

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
		
		System.out.println("After removal: ");
		deleteNode(n5);
		n1.printFromHeadtoTail();
	}

	// Dirty trick, as the question is not clear
	// This is value manipulation rather that deletion 
	public static void deleteNode(ListNode node) {
		
		node.val = node.next.val; 
		node.next = node.next.next;
	}
}












