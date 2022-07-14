package questions.trees;

import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/*
Given a binary tree, find the lowest common ancestor
(LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q
as the lowest node in T that has both p and q as descendants
(where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */
public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    public static void main(String[] args) {

        /***************(Tree)********************/
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n13 = new TreeNode(13);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n9 = new TreeNode(9);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n10 = new TreeNode(10);

        n7.left = n2;
        n7.right = n3;
        n2.left = n13;
        n2.right = n5;
        n3.left = n1;
        n3.right = n9;
        n9.left = n4;
        n9.right = n6;
        n5.left = n10;

        n7.printTree();
        /***************(Tree)********************/

        TreeNode targetNode1 = n1;
        TreeNode targetNode2 = n6;
        System.out.println("Target Node 1: " + targetNode1.val);
        System.out.println("Target Node 2: " + targetNode2.val);

        TreeNode lwstComnAncs = lowestCommonAncestor(n7, targetNode1, targetNode2);

        System.out.println("Lowest Common Ancestor: " + lwstComnAncs.val);
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode nodeA, TreeNode nodeB) {

        List<TreeNode> list1 = findPathBetween(root, nodeA);
        List<TreeNode> list2 = findPathBetween(root, nodeB);

        // Generate an iterator. Start just after the last element.
        ListIterator<TreeNode> iter1 = list1.listIterator(list1.size());
        ListIterator<TreeNode> iter2 = list2.listIterator(list2.size());
        TreeNode lowestCommon = null;

        while(iter1.hasPrevious() && iter2.hasPrevious()) { // Iterate in reverse.

            TreeNode node1 = iter1.previous();
            TreeNode node2 = iter2.previous();

            if (node1 == node2) {
                lowestCommon = node1;
            }
            else {
                return lowestCommon;
            }
        }
        return lowestCommon;
    }

    public static Stack<TreeNode> findPathBetween(TreeNode root, TreeNode target) {

        if (root == null) {
            return null;
        }
        if (root == target) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(target);
            return stack;
        }
        Stack<TreeNode> leftStack  = findPathBetween(root.left, target);
        Stack<TreeNode> rightStack = findPathBetween(root.right, target);

        if (leftStack != null) {
            leftStack.push(root);
            return leftStack;
        }
        if (rightStack != null) {
            rightStack.push(root);
            return rightStack;
        }
        return null;
    }

}
