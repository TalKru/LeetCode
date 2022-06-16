package questions.trees;
/*
Given the root of a binary search tree,
rearrange the tree in in-order so that the leftmost node in the tree
is now the root of the tree,
and every node has no left child and only one right child.

Example 1:
Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

Example 2:
Input: root = [5,1,7]
Output: [1,null,5,null,7]

Constraints:
The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000
 */
public class _897_Increasing_Order_Search_Tree {

    public static void main(String[] args) {

        /***************(BST Tree)********************/
        TreeNode n25  = new TreeNode(25);
        TreeNode n15  = new TreeNode(15);
        TreeNode n10  = new TreeNode(10);
        //TreeNode n4  = new TreeNode(4);
        //TreeNode n12 = new TreeNode(12);
        TreeNode n22  = new TreeNode(22);
        //TreeNode n18  = new TreeNode(18);
        //TreeNode n24  = new TreeNode(24);
        TreeNode n50  = new TreeNode(50);
        TreeNode n70 = new TreeNode(70);
        //TreeNode n90  = new TreeNode(90);
        //TreeNode n31 = new TreeNode(31);
        //TreeNode n35  = new TreeNode(35);
        //TreeNode n44 = new TreeNode(44);
        //TreeNode n66 = new TreeNode(66);
        n25.left = n15;
        n25.right = n50;
        n15.left = n10;
        n15.right = n22;
        //n10.left = n4;
        //n10.right = n12;
        //n22.left = n18;
        //n22.right = n24;
        //n50.left = n35;
        n50.right = n70;
        //n35.left = n31;
        //n35.right = n44;
        //n70.left = n66;
        //n70.right = n90;

        n25.printTree(); // root of BST
        /***************(BST Tree)********************/

        TreeNode inOrderRoot = increasingBST(n25);

        System.out.println("==============================================(Result:)");

        inOrderRoot.printTree();
    }
    // ========================================================================//


    public static TreeNode increasingBST(TreeNode root) {

        inOrderTravListMaker(root);

        prevNode.left = null; // last element fix, might have remaining left connection that will cause cycle

        return listRoot;
    }

    private static TreeNode prevNode = null;
    private static TreeNode listRoot = null;

    private static void inOrderTravListMaker(TreeNode node) {

        if (node == null) {
            return;
        }

        // 1. left
        if (node.left != null ) {
            inOrderTravListMaker(node.left);
        }

        // 2. node
        if (prevNode != null) {

            prevNode.left = null;
            prevNode.right = node;
        }
        else {
            listRoot = node;
        }
        prevNode = node;

        // 3. right
        if (node.right != null) {
            inOrderTravListMaker(node.right);
        }
    }
    // ========================================================================//

    /*
    // Complex solution - Recursive
    public static TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    private static TreeNode increasingBST(TreeNode node, TreeNode tail) {

        if (node == null) {
            return tail;
        }
        TreeNode res = increasingBST(node.left, node);

        node.left = null;
        node.right = increasingBST(node.right, tail);

        return res;
    }
    */
    // ========================================================================//

}
