package questions.linkedList;
/*
Given the head of a singly linked list,
return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

Constraints:
The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
 */
public class _876_Middle_of_the_Linked_List {

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
        n1.printFromHeadtoTail();

        ListNode mid = middleNode(n1);

        System.out.println("Middle_of_the_Linked_List: ");
        mid.printFromHeadtoTail();
    }

    public static ListNode middleNode(ListNode head) {

        if(head == null) {
            return null;
        }
        int listLen = 0;
        ListNode temp = head;

        while (temp != null){

            listLen++;
            temp = temp.next;
        }
        int midNodeIndex = (listLen / 2) + 1;
        temp = head; // reset temp node

        for (int i = 1; i < midNodeIndex; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
