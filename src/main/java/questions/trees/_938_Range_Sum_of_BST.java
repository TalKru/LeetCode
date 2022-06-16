package questions.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root node of a binary search tree and two integers low and high,
return the sum of values of all nodes
with a value in the inclusive range [low, high].

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

Constraints:
The number of nodes in the tree is in the range [1, 2 * 10^4].
1 <= Node.val <= 10^5
1 <= low <= high <= 10^5
All Node.val are unique.
 */
public class _938_Range_Sum_of_BST {

    public static void main(String[] args) {

        /***************(BST Tree)********************/
        TreeNode n25 = new TreeNode(25);
        TreeNode n15 = new TreeNode(15);
        TreeNode n10 = new TreeNode(10);
        TreeNode n4 = new TreeNode(4);
        TreeNode n12 = new TreeNode(12);
        TreeNode n22 = new TreeNode(22);
        TreeNode n18 = new TreeNode(18);
        TreeNode n24 = new TreeNode(24);
        TreeNode n50 = new TreeNode(50);
        TreeNode n70 = new TreeNode(70);
        TreeNode n90 = new TreeNode(90);
        TreeNode n31 = new TreeNode(31);
        TreeNode n35 = new TreeNode(35);
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

        int low = 4;
        int high = 12;
        int sum = rangeSumBST(n25, low, high);
        //int sum = rangeSumBST2(n25, low, high);

        System.out.println("Low = " + low);
        System.out.println("High = " + high);
        System.out.println("sum of values of all nodes with a value in the inclusive range: " + sum);
    }


    // Recursive
    public static int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


    // Iterative
    public static int rangeSumBST2(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }
        int rangeSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode temp = queue.poll();

            if (temp.val >= low && temp.val <= high) { // within the valid range, traverse in both directions
                rangeSum += temp.val;

                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
            }
            else if (temp.val < low && temp.right != null) { // value is too low, keep searching in higher range
                queue.add(temp.right);
            }
            else if (temp.val > high && temp.left != null) { // value is too high, keep searching in lower range
                queue.add(temp.left);
            }
        }
        return rangeSum;
    }

}

