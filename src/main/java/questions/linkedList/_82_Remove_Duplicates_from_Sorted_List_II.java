package questions.linkedList;

/*
Given the head of a sorted linked list,
delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.
Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */
public class _82_Remove_Duplicates_from_Sorted_List_II {

    public static void main(String[] args) {

        /*************(LinkedList)*************/
        ListNode n1 = new ListNode(1); // root
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(4);
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

        ListNode resNode = deleteDuplicates(n1);

        System.out.println("After: ");
        resNode.printFromHeadtoTail();
    }

    // Note function removes ALL instances of Duplicate values!
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head; // at least 2 node from this point
        }
        ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
        ListNode fast = head;
        ListNode slow = fakeHead;

        slow.next = fast;

        while (fast != null) {

            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next != fast) {    // duplicates detected
                slow.next = fast.next;  // remove the duplicates
                fast = slow.next;       // reposition the fast pointer
            }
            else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return fakeHead.next;
    }

}
