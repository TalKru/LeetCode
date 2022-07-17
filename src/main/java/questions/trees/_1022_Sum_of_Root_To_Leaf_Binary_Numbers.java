package questions.trees;

/*
You are given the root of a binary tree where each node has a value 0 or 1.
Each root-to-leaf path represents a
binary number starting with the most significant bit.

For example, if the path is 0 -> 1 -> 1 -> 0 -> 1,
then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented
by the path from the root to that leaf.
Return the sum of these numbers.
The test cases are generated so that the answer fits in a 32-bits integer.

Example 1:
Input: root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

Example 2:
Input: root = [0]
Output: 0

Constraints:
The number of nodes in the tree is in the range [1, 1000].
Node.val is 0 or 1.
 */
public class _1022_Sum_of_Root_To_Leaf_Binary_Numbers {

    public static void main(String[] args) {

        /***************(Binary Tree)********************/
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        n1.printTree();
        /***************(Binary Tree)********************/

        int binAddResult = sumRootToLeaf(n1);

        System.out.println("Sum_of_Root_To_Leaf_Binary_Numbers: " + binAddResult);
    }


    public static int sumRootToLeaf(TreeNode root) {
        return DFSpathSums(root, 0);
    }

    private static int DFSpathSums(TreeNode root, int binSum) {

        if (root == null) {
            return 0;
        }
        binSum = (2 * binSum) + root.val;

        if (root.left == null && root.right == null) {
            return binSum;
        }
        return DFSpathSums(root.left, binSum) + DFSpathSums(root.right, binSum);
    }

}
