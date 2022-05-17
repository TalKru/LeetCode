package questions.linkedList;
/*
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes
(i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]

Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 */
public class _24_Swap_Nodes_in_Pairs {

    public static void main(String[] args) {

        /*************(LinkedList)*************/
        ListNode n1 = new ListNode(1); // root
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
        /*************(LinkedList)*************/

        ListNode res = swapPairs(n1);
        //ListNode res = swapPairsCheat(n1);
        res.printFromHeadtoTail();
    }

    // O(n)
    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        // when we swap 2 nodes we must keep track of prev.next
        ListNode prev = null; // catch #1

        // after the first swap the head changes
        head = head.next; // catch #2

        while (p1 != null && p2 != null) {
            /////////////
            p1.next = p3;
            p2.next = p1;
            /////////////
            if(prev != null) {
                prev.next = p2;
            }
            if(p3 != null && p3.next != null) {
                prev = p1;
                p1 = p3;
                p2 = p1.next;
                p3 = p2.next;
            }
            else {
                return head;
            }
        }
        return head;
    }

    // invalid "cheat" solution
    public static ListNode swapPairsCheat(ListNode head) {

        ListNode temp = head;

        while(temp != null && temp.next != null){

            int tempVal = temp.val;
            temp.val = temp.next.val;
            temp.next.val = tempVal;

            temp = temp.next.next; // skip 1 node
        }
        return head;
    }

}
