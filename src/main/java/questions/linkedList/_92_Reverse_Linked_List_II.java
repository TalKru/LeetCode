package questions.linkedList;

/*
Given the head of a singly linked list and two integers
left and right where left <= right,
reverse the nodes of the list from position left to position right,
and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 */
public class _92_Reverse_Linked_List_II {

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
        System.out.println("Before: ");
        n1.printFromHeadtoTail();
        /*************(LinkedList)*************/

        int start = 3;
        int end = 7;
        ListNode res = reverseBetween(n1, start, end);

        System.out.println("Reversed from: (" + start + ") to: (" + end + ")");
        res.printFromHeadtoTail();
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        return dummy.next;
    }

}
