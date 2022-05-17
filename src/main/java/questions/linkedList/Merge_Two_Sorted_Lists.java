package questions.linkedList;
/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

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

class Merge_Two_Sorted_Lists {

	public static void main(String[] args) {

		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(9);
		ListNode n4 = new ListNode(47);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode m1 = new ListNode(1);
		ListNode m2 = new ListNode(3);
		ListNode m3 = new ListNode(7);
		m1.next = m2;
		m2.next = m3;

		System.out.println("Input sorted lists: ");
		
		n1.printFromHeadtoTail();
		m1.printFromHeadtoTail();
		ListNode result = mergeTwoLists(n1, m1);
		
		System.out.println("Result, merged list: ");
		result.printFromHeadtoTail();
	} 


	/* Memory saving approach, requires rearanging 2 sorted lists into 1 sorted list */
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
		if(list1 != null) {         // link the remaining of the unfinished list
			itrtNode.next = list1;
		}
		if(list2 != null) {
			itrtNode.next = list2;
		}
		return head.next;
	}

	
	/* Fast approach, also easy, creating new merged list from the l1, l2*/
	//		public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	//			
	//			if(list1 == null) { return list2; }
	//			if(list2 == null) { return list1; }
	//	
	//			ListNode list3 = new ListNode();
	//			ListNode headNodeCopy = list3;               // save the head
	//			
	//			while(list1 != null && list2 != null) {
	//	
	//				
	//				list3.val = Math.min(list1.val, list2.val);
	//				list3.next = new ListNode();
	//				list3 = list3.next;
	//	
	//				if(list1.val < list2.val) { list1 = list1.next; }
	//				else                      { list2 = list2.next; }
	//			}
	//			
	//			// copy the remainder of the longer list
	//			while(list1 != null) {
	//				
	//				list3.val = list1.val;
	//				list1 = list1.next;        // now done with list1 node
	//				
	//				if(list1 != null) {
	//					list3.next = new ListNode();
	//					list3 = list3.next;
	//				}
	//			}
	//			while(list2 != null) {
	//				
	//				list3.val = list2.val;
	//				list2 = list2.next;        // now done with list2 node
	//				
	//				if(list2 != null) {
	//					list3.next = new ListNode();
	//					list3 = list3.next;
	//				}
	//				
	//			}
	//			return headNodeCopy;
	//		}

}