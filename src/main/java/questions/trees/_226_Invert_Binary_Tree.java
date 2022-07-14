package questions.trees;

/*
Given the root of a binary tree,
invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
public class _226_Invert_Binary_Tree {

    public static void main(String[] args) {

        //======================(Tree)======================//
        TreeNode n7 = new TreeNode(7); // root
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n13 = new TreeNode(13);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n9 = new TreeNode(9);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
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
        //======================(Tree)======================//

        System.out.println("InvertTree result: ");
        invertTree(n7);
        n7.printTree();
    }

    public static TreeNode invertTree(TreeNode root) {
        childSwap(root);
        return root;
    }

    private static void childSwap(TreeNode node) {

        if (node == null || node.left == null && node.right == null) {
            return;
        }
        // swap children
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;

        childSwap(node.left);
        childSwap(node.right);
    }

}
