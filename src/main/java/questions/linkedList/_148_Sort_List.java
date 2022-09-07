package questions.linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given the head of a linked list,
return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105

Follow up: Can you sort the linked list in
O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class _148_Sort_List {

    public static void main(String[] args) {

        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(8);
        ListNode n6 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println("Before: ");
        n1.printFromHeadtoTail();

        ListNode sortedHead = sortList(n1);

        System.out.println("Sort_List: ");
        sortedHead.printFromHeadtoTail();
    }

    // ========================================================================================= /
    // Easy method but much slower,
    // Copy to list, sort, then copy sorted element back to linked list
    public static ListNode sortList2(ListNode head) {

        List<Integer> list = new ArrayList<>();
        ListNode tempNode = head;
        int vals = 0;

        while (tempNode != null) {
            vals++;
            list.add(tempNode.val);
            tempNode = tempNode.next;
        }
        Collections.sort(list);

        tempNode = head;
        int i = 0;
        while (vals != 0) {
            tempNode.val = list.get(i++);
            tempNode = tempNode.next;
            vals--;
        }
        return head;
    }

    // ========================================================================================= /
    private static class MergeHelper {
        public ListNode newHead;
        public ListNode newTail;
    }

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHeadOne = new ListNode(0);
        ListNode dummyHeadTwo = new ListNode(0);
        ListNode dummySortedHead = new ListNode(0);
        ListNode dummySortedLast = dummySortedHead;
        ListNode unvisitedNode = head;

        MergeHelper mergeRst = new MergeHelper();

        int listLength = 0;
        int level = 0;

        while (unvisitedNode != null && unvisitedNode.next != null) {

            unvisitedNode = addNode(dummyHeadOne, unvisitedNode, 1 << level);
            unvisitedNode = addNode(dummyHeadTwo, unvisitedNode, 1 << level);

            merge(dummyHeadOne.next, dummyHeadTwo.next, mergeRst);

            dummySortedLast.next = mergeRst.newHead;
            dummySortedLast = mergeRst.newTail;

            listLength += 2;
        }
        if (unvisitedNode != null) {
            dummySortedLast.next = unvisitedNode;
            listLength++;
        }
        level++;

        while (listLength > 1 << level) {

            dummySortedLast = dummySortedHead;
            unvisitedNode = dummySortedHead.next;

            while (unvisitedNode != null) {
                unvisitedNode = addNode(dummyHeadOne, unvisitedNode, 1 << level);
                unvisitedNode = addNode(dummyHeadTwo, unvisitedNode, 1 << level);
                merge(dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
                dummySortedLast.next = mergeRst.newHead;
                dummySortedLast = mergeRst.newTail;
            }
            level++;
        }
        return dummySortedHead.next;
    }

//    merge listOne and listTwo.
//    Save the sorted list head into rst.newHead
//    Save the last node of the sorted list into rst.newTail
    private static void merge(ListNode listOne, ListNode listTwo, MergeHelper rst) {

        ListNode dummyHead = new ListNode(0);
        ListNode lastNode = dummyHead;

        while (listOne != null && listTwo != null) {

            if (listOne.val < listTwo.val) {
                lastNode.next = listOne;
                listOne = listOne.next;
            }
            else {
                lastNode.next = listTwo;
                listTwo = listTwo.next;
            }
            lastNode = lastNode.next;
        }

        while (listOne != null) {
            lastNode.next = listOne;
            listOne = listOne.next;
            lastNode = lastNode.next;
        }
        while (listTwo != null) {
            lastNode.next = listTwo;
            listTwo = listTwo.next;
            lastNode = lastNode.next;
        }
        rst.newHead = dummyHead.next;
        rst.newTail = lastNode;
    }


//     add at max #"count" nodes into "head" from "source"
//     return the new position of source after adding.
    private static ListNode addNode(ListNode head, ListNode source, int count) {

        while (count > 0 && source != null) {
            head.next = source;
            head = head.next;
            source = source.next;
            count--;
        }
        head.next = null;
        return source;
    }
// ========================================================================================= /
}

