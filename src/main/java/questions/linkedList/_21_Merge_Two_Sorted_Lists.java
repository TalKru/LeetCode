package questions.linkedList;
/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. 
The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 
Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/
public class _21_Merge_Two_Sorted_Lists {

	public static void main(String[] args) {

		/*************(LinkedList)*************/
		ListNode n1 = new ListNode(1); // root
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		System.out.println("List 1: ");
		n1.printFromHeadtoTail();

		ListNode m1 = new ListNode(0);
		ListNode m2 = new ListNode(0);
		ListNode m3 = new ListNode(4);
		ListNode m4 = new ListNode(7);
		ListNode m5 = new ListNode(8);
		ListNode m6 = new ListNode(9);
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = m5;
		m5.next = m6;

		System.out.println("List 2: ");
		m1.printFromHeadtoTail();
		/*************(LinkedList)*************/

		ListNode mergedList = mergeTwoLists(n1, m1);
		System.out.println("Merged List: ");
		mergedList.printFromHeadtoTail();
	}


	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		if(list1 == null) { 
			return list2; 
		}
		if(list2 == null) { 
			return list1; 
		}
		ListNode itrtNode = new ListNode();
		ListNode head = itrtNode;

		while(list1 != null && list2 != null) {

			if(list1.val < list2.val) {

				itrtNode.next = list1;
				itrtNode = itrtNode.next;
				list1 = list1.next;
			}
			else {
				itrtNode.next = list2;
				itrtNode = itrtNode.next;
				list2 = list2.next;
			}
		}
		if(list1 != null) {
			itrtNode.next = list1;
		}
		if(list2 != null) {
			itrtNode.next = list2;
		}
		return head.next;
	}

}

