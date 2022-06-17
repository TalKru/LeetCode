package questions.linkedList;

/*
Given the head of a sorted linked list,
delete all duplicates such that each element appears only once.
Return the linked list sorted as well.

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

		/*************(LinkedList)*************/
		ListNode n1 = new ListNode(1); // root
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(7);
		ListNode n6 = new ListNode(7);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		System.out.println("Before: ");
		n1.printFromHeadtoTail();
		/*************(LinkedList)*************/
		
		ListNode headResult = deleteDuplicates(n1);
		
		System.out.println("No duplicates linked list:");
		headResult.printFromHeadtoTail();
	}

	/*
	 Quicker
	 Two pointer, curr & next
	 in case of multiple Duplicates, 'next' will run until hits a distinct value
	 */
	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head; // at least 2 node from this point
		}
		ListNode currNode = head;
		ListNode nextNode = head.next;

		while (nextNode != null) {

			if (currNode.val == nextNode.val) {

				while (nextNode != null && nextNode.val == currNode.val) {
					nextNode = nextNode.next;
				}
				currNode.next = nextNode;
			}
			else {
				currNode = currNode.next;
				nextNode = nextNode.next;
			}
		}
		return head;
	}

	/*
	removes next Duplicate.
	 first attempt, works, a bit less efficient in case of long repeating values
	 single pointer
	 */
	public static ListNode deleteDuplicates2(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
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
			else { // diff values
				curr = curr.next;
			}
		}
		return head;
	}

}
