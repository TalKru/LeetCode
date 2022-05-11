package questions.linkedList;

//Definition for singly-linked list.
public class ListNode {
	
	public int val;
	public ListNode next;

	public ListNode() {}

	public ListNode(int val) { 
		this.val = val; 
	}

	public ListNode(int val, ListNode next) {
		this.val = val; 
		this.next = next; 
	}
	
	public void printFromHeadtoTail() {
		
		ListNode head = this;
		
		while(head != null) {
			System.out.print("\033[0;32m" + "(" + head.val + ")-->");
			head = head.next;
		}
		System.out.println("null");
	}
}
