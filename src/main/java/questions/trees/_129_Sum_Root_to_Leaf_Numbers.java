package questions.trees;

/*
You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers.
Test cases are generated so that the answer will fit in a 32-bit integer.
A leaf node is a node with no children.

Example 1:
Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:
Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

Constraints:
The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 9
The depth of the tree will not exceed 10.
 */
public class _129_Sum_Root_to_Leaf_Numbers {

    public static void main(String[] args) {

        /***************(Tree)********************/
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n9 = new TreeNode(9);

        n7.left = n2;
        n7.right = n3;
        n2.right = n5;
        n3.left = n1;
        n3.right = n9;

        n7.printTree();
        /***************(Tree)********************/

        int res = sumNumbers(n7);
        System.out.println("Path sums: " + res);
    }

    // ================================================================= //
    // Recursive - fastest
    public static int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return pathSums(root, 0);
    }

    private static int pathSums(TreeNode node, int pathDigitNum) {

        if (node == null) {
            return 0; // when node has only 1 child, the other child is null, and will reach this case, and will return 0 that won't affecr the result
        }
        pathDigitNum = 10 * pathDigitNum + node.val;

        if (node.left == null && node.right == null) { // leaf reached
            return pathDigitNum;
        }
        int leftSum = pathSums(node.left, pathDigitNum);
        int rightSum = pathSums(node.right, pathDigitNum);

        return leftSum + rightSum;
        //return pathSums(node.left, sumStr) + pathSums(node.right, sumStr);
    }

    // ================================================================= //
    // Recursive - using string
    public static int sumNumbers3(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return pathSums3(root, "");
    }

    private static int pathSums3(TreeNode node, String sumStr) {

        if (node == null) {
            return 0;
        }
        sumStr += String.valueOf(node.val);

        if (node.left == null && node.right == null) {

            return Integer.parseInt(sumStr);
        }
        return pathSums3(node.left, sumStr) + pathSums3(node.right, sumStr);
    }

    // ================================================================= //
    // Recursive with static var - using string
    public static int sumNumbers2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        sum = 0;

        pathSums2(root, "");

        return (int) sum;
    }

    private static long sum;

    private static void pathSums2(TreeNode node, String sumStr) {

        // add the node val to string
        sumStr += String.valueOf(node.val);

        // if leaf - save the num as int to the global sum
        if (node.left == null && node.right == null) {

            sum += Integer.parseInt(sumStr);
            return;
        }
        // call the children after add node value
        if (node.left != null) {
            pathSums2(node.left, sumStr);
        }
        if (node.right != null) {
            pathSums2(node.right, sumStr);
        }
    }
    // ================================================================= //
}
