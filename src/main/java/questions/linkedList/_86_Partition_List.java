package questions.linkedList;
/*
Given the head of a linked list and a value x,
partition it such that all nodes less than x
come before nodes greater than or equal to x.

You should preserve the original relative order
of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]

Constraints:
The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
 */
public class _86_Partition_List {

    public static void main(String[] args) {

        /*************(LinkedList)*************/
        ListNode root = new ListNode(47); // root
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(47);
        root.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        root.printFromHeadtoTail();
        /*************(LinkedList)*************/
        int x = 7;

        ListNode res =  partition(root, x);
        res.printFromHeadtoTail();
    }

    public static ListNode partition(ListNode head, int x) {

        if(head == null) {
            return null;
        }
        ListNode head1 = new ListNode(Integer.MIN_VALUE);
        ListNode tail1 = head1;
        ListNode head2 = new ListNode(Integer.MIN_VALUE);
        ListNode tail2 = head2;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p1 != null) {

            if(p1.val < x) {
                tail1.next = p1;
                tail1 = tail1.next;
            }
            else {
                tail2.next = p1;
                tail2 = tail2.next;
            }
            p1 = p2;
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        tail1.next = head2.next; // connect 2 lists [list1 -> list2]
        tail2.next = null;       // close the end of the new list [...->null]

        return head1.next;
    }

}
