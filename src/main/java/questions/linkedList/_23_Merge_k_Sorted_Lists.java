package questions.linkedList;


/*
You are given an array of k linked-lists lists,
each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

Constraints:
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 10^4.
 */
public class _23_Merge_k_Sorted_Lists {

    public static void main(String[] args) {

        /*************(LinkedList2)*************/
        ListNode n1 = new ListNode(1);
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

        ListNode k1 = new ListNode(2);
        ListNode k2 = new ListNode(4);
        ListNode k3 = new ListNode(13);
        ListNode k4 = new ListNode(71);
        ListNode k5 = new ListNode(81);
        ListNode k6 = new ListNode(91);
        k1.next = k2;
        k2.next = k3;
        k3.next = k4;
        k4.next = k5;
        k5.next = k6;

        System.out.println("List 3: ");
        k1.printFromHeadtoTail();
        /*************(LinkedList)*************/

        ListNode[] lists = new ListNode[3];
        lists[0] = n1;
        lists[1] = m1;
        lists[2] = k1;

        ListNode mergedList = mergeKLists(lists);
        System.out.println("Merged List: ");
        mergedList.printFromHeadtoTail();
    }

    // ================================================================================= //
    /*
    Merge Lists One-By-One
    We need to merge k lists by merging (k-1) times.
    Time: O(kN)
    Merge two sorted lists in O(n) time where n is the total number of nodes in two lists. (worst case)
    To sum up we have: O(\sum_{i=1}^{k-1}(i * \frac{N}{k} + \frac{N}{k}) = O(kN). (key: n = \frac{N}{k}) skip it...
    Space: O(1) since we merge in place.
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length < 2) {
            return null;
        }

        ListNode firstHead = lists[0];

        for (int i = 1; i < lists.length; i++) {

            firstHead = mergeTwoLists(firstHead, lists[i]);
        }
        return firstHead;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummyHead;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        while (l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }
        while (l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }
        return dummyHead.next;
    }
    // ================================================================================= //
    /*
    Merge Lists with Divide And Conquer
    In effect, we don't need to traverse most nodes many times repeatedly.
    We can divide lists in half until there is only one list.
    Merge them one by one to get the final result. It's similar to mergesort.

    Note:
    Recall of the left-leaning and right-leaning cases.
    The base case is thoughtful. lo > hi actually won't occur. And lists[lo] won't change other elements on the other side.
    lists.length == 0 condition is very important.
    Input case: [].

    Time: O(N\log{k}) 2 ms
    Space: O(\log{k}) if we use recursion (depth of the recursion tree).
     */
    // mergeDivideAndConquer - O(kN)
    public static ListNode mergeDivideAndConquer(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        return divideAndConquer(lists, 0, lists.length - 1);
    }

    private static ListNode divideAndConquer(ListNode[] lists, int lo, int hi) {

        if (lo > hi) { // invalid
            return null;
        }
        if (lo == hi) { // size = 1
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2; // left-leaning

        ListNode left = divideAndConquer(lists, lo, mid);
        ListNode right = divideAndConquer(lists, mid + 1, hi);

        return mergeTwoLists(left, right);
    }
    // ================================================================================= //
}
