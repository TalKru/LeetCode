package questions.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a Binary Search Tree and a target number k,
return true if there exist two elements in the BST
such that their sum is equal to the given target.

Example 1:
Input: root = [5,3,6,2,4,null,7], k = 9
Output: true

Example 2:
Input: root = [5,3,6,2,4,null,7], k = 28
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-10^4 <= Node.val <= 10^4
root is guaranteed to be a valid binary search tree.
-10^5 <= k <= 10^5
 */
public class _653_Two_Sum_IV_Input_is_a_BST {

    public static void main(String[] args) {

        /***************(Tree)********************/
        TreeNode n7  = new TreeNode(7);
        TreeNode n2  = new TreeNode(6);
        TreeNode n3  = new TreeNode(10);
        TreeNode n13 = new TreeNode(3);
        TreeNode n5  = new TreeNode(4);
        TreeNode n1  = new TreeNode(9);
        TreeNode n9  = new TreeNode(19);
        n7.left = n2;
        n7.right = n3;
        n2.left = n13;
        n2.right = n5;
        n3.left = n1;
        n3.right = n9;

        n7.printTree();
        /***************(Tree)********************/

        // int k = 35; // false example
        int k = 25;    // true example
        boolean res  = findTarget(n7, k);
        boolean res2 = findTarget2(n7, k);
        boolean res3 = findTarget3(n7, k);

        System.out.println("Sum = " + k);
        System.out.println("Two_Sum_IV_Input_is_a_BST: " + res);
        System.out.println("Two_Sum_IV_Input_is_a_BST: " + res2);
        System.out.println("Two_Sum_IV_Input_is_a_BST: " + res3);
    }

    //----------------------------------------------------------------------------//
    /*
    Iterative traversal using Queue
    While traversing the tree nodes we keep track
    of the prev visited nodes and using HashSet
    to check if the combined sum of current node
    with any visited prev node is equal to k
     */
    public static boolean findTarget(TreeNode root, int sum) {

        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (set.contains(sum - node.val)) {
                return true;
            } else {
                set.add(node.val);
            }
            if (node.left != null) {

                queue.add(node.left);
            }
            if (node.right != null) {

                queue.add(node.right);
            }
        }
        return false;
    }

    //----------------------------------------------------------------------------//
    /*
       Recursive:
    1. Get a sorted array by in-order traversing a BST.
    2. Solve Two Sum problem in a sorted array.
     */
    public static boolean findTarget2(TreeNode root, int k) {

        List<Integer> list = new LinkedList<>();

        inOrderTrav(root, list);

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {

            int sum = list.get(i) + list.get(j);

            if (sum == k) {
                return true;
            }
            else if (sum < k) {
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }

    private static void inOrderTrav(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }
        inOrderTrav(node.left, list);
        list.add(node.val);
        inOrderTrav(node.right, list);
    }
    //----------------------------------------------------------------------------//

    // Recursive, not efficient, not exploiting BST attribute
    public static boolean findTarget3(TreeNode root, int k) {

        HashSet<Integer> set = new HashSet<>();

        return recurTreeTraversal(root, k, set);
    }

    private static boolean recurTreeTraversal(TreeNode node, int sum, HashSet<Integer> set) {

        if (node == null) {
            return false;
        }
        if (set.contains(sum - node.val)) {
            return true;
        } else {
            set.add(node.val);
        }
        boolean leftRes = recurTreeTraversal(node.left, sum, set);
        boolean rightRes = recurTreeTraversal(node.right, sum, set);

        return leftRes || rightRes;
    }
    //----------------------------------------------------------------------------//
}
