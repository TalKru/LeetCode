package questions.trees;
/*
A binary tree is uni-valued if every node in the tree has the same value.
Given the root of a binary tree,
return true if the given tree is uni-valued,
or false otherwise.

Example 1:
Input: root = [1,1,1,1,1,null,1]
Output: true

Example 2:
Input: root = [2,2,2,5,2]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 100].
0 <= Node.val < 100
 */
public class _965_Univalued_Binary_Tree {

    public static void main(String[] args) {

        /***************(Tree)********************/
        TreeNode n7  = new TreeNode(0);
        TreeNode n2  = new TreeNode(0);
        TreeNode n3  = new TreeNode(0);
        TreeNode n13 = new TreeNode(0);
        TreeNode n5  = new TreeNode(0);
        TreeNode n1  = new TreeNode(1745);
        TreeNode n9  = new TreeNode(0);
        TreeNode n4  = new TreeNode(0);
        TreeNode n6  = new TreeNode(0);
        TreeNode n10 = new TreeNode(0);

        n7.left = n2;  n7.right = n3;
        n2.left = n13; n2.right = n5;
        n3.left = n1;  n3.right = n9;
        n9.left = n4;  n9.right = n6;
        n5.left = n10;

        BTreePrinter.printNode(n7);
        /***************(Tree)********************/

        boolean res = isUnivalTree(n7);
        System.out.println("is Unival Tree? -> " + res);
    }

    public static boolean isUnivalTree(TreeNode root) {

        if (root == null) {
            return true;
        }
        if (root.left != null && root.val != root.left.val) {
            return false;
        }
        if (root.right != null && root.val != root.right.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

}
