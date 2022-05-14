package questions.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-2^31 <= Node.val <= 2^31 - 1
 */
public class _98_Validate_Binary_Search_Tree {

    public static void main(String[] args) {

        /***************(BST Tree)********************/
        TreeNode n25  = new TreeNode(25);
        TreeNode n15  = new TreeNode(15);
        TreeNode n10  = new TreeNode(10);
        TreeNode n4  = new TreeNode(4);
        TreeNode n12 = new TreeNode(12);
        TreeNode n22  = new TreeNode(22);
        TreeNode n18  = new TreeNode(18);
        TreeNode n24  = new TreeNode(24);
        TreeNode n50  = new TreeNode(50);
        TreeNode n70 = new TreeNode(70);
        TreeNode n90  = new TreeNode(90);
        TreeNode n31 = new TreeNode(31);
        TreeNode n35  = new TreeNode(35);
        TreeNode n44 = new TreeNode(44);
        TreeNode n66 = new TreeNode(66);
        n25.left = n15;
        n25.right = n50;
        n15.left = n10;
        n15.right = n22;
        n10.left = n4;
        n10.right = n12;
        n22.left = n18;
        n22.right = n24;
        n50.left = n35;
        n50.right = n70;
        n35.left = n31;
        n35.right = n44;
        n70.left = n66;
        n70.right = n90;

        n25.printTree(); // root of BST
        /***************(BST Tree)********************/

        System.out.println("(Iterative) isValidBST: " + isValidBST(n25));
        System.out.println("(Recursive) isValidBST: " + isValidBST2(n25));
    }

    // Iterative, faster
    public static boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) { // in order

            while (curr != null) { /* Reach the left most Node of the curr Node */
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            /* ---------------------------- test valid BST */
            list.add(curr.val);

            if (list.size() >= 2 && list.get(list.size() - 1) <= list.get(list.size() - 2)) {
                return false;
            }
            /* ------------------------------------------- */
            curr = curr.right;
        }
        return true;
    }

    // Recursive, using inOrder travel
    public static boolean isValidBST2(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        inOrderValCollect(root, list);

        for (int i = 1; i < list.size(); i++) { // start from second value

            if (list.get(i) <= list.get(i - 1)){
                return false;
            }
        }
        return true;
    }
    private static void inOrderValCollect(TreeNode node, List<Integer> list){

        if (node == null){
            return;
        }
        inOrderValCollect(node.left, list);
        list.add(node.val);
        inOrderValCollect(node.right, list);
    }
}



/*
    // wrong solution as it's not cover the cases when
    // BST trait is broken deeper than parent-child level
    // still a nice try :)
    public static boolean isValidBST(TreeNode root) {

        return isBST(root.left, root.val, true) && isBST(root.right, root.val, false);
    }
    private static boolean isBST(TreeNode node, int parentVal, boolean isLeftChild) {

        if (node == null) {
            return true;
        }
        if (isLeftChild && node.val >= parentVal) { // left child
            return false;
        }
        else if (!isLeftChild && node.val <= parentVal){ // is right child
            return false;
        }
        boolean lefteRec = isBST(node.left, node.val, true);
        boolean rightRec = isBST(node.right, node.val, false);

        return  lefteRec && rightRec;
    }
    */