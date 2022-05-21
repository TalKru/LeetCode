package questions.trees;

/*
You are given the root of a binary search tree (BST),
where the values of exactly two nodes of the tree were swapped by mistake.
Recover the tree without changing its structure.

Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1
because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3
because 2 < 3. Swapping 2 and 3 makes the BST valid.

Constraints:
The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
 */
public class _99_Recover_Binary_Search_Tree {

    public static void main(String[] args) {

        /***************(BST Tree)********************/
        TreeNode n25 = new TreeNode(25);
        TreeNode n15 = new TreeNode(15);
        TreeNode n10 = new TreeNode(10);
        TreeNode n4 = new TreeNode(4);
        TreeNode n12 = new TreeNode(12);
        TreeNode n22 = new TreeNode(35); // swapped (22)
        TreeNode n18 = new TreeNode(18);
        TreeNode n24 = new TreeNode(24);
        TreeNode n50 = new TreeNode(50);
        TreeNode n70 = new TreeNode(70);
        TreeNode n90 = new TreeNode(90);
        TreeNode n31 = new TreeNode(31);
        TreeNode n35 = new TreeNode(22); // swapped (35)
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

        Solution sol = new Solution();
        sol.recoverTree(n25);
        System.out.println("Fixed BST:");
        n25.printTree();
    }
}


class Solution {
    TreeNode fstElement = null;
    TreeNode secElement = null;
    TreeNode prevElement = null;

    public void recoverTree(TreeNode root) {

        inOrderTrav(root);

        int temp = fstElement.val;
        fstElement.val = secElement.val;
        secElement.val = temp;
    }

    private void inOrderTrav(TreeNode root) {

        if (root == null) {
            return;
        }
        inOrderTrav(root.left);

        if (prevElement != null) {
            if (fstElement == null && prevElement.val >= root.val) {
                fstElement = prevElement;
            }
        }
        if (fstElement != null && prevElement.val >= root.val) {
            secElement = root;
        }
        prevElement = root;
        inOrderTrav(root.right);
    }
}