package questions.trees;
/*
Print binary tree with O(1) space
in no particular order.
 */
public class _0002_Print_Tree_No_Extra_Space {

    public static void main(String[] args) {

        /***************(Tree)********************/
        TreeNode n7  = new TreeNode(7);
        TreeNode n2  = new TreeNode(2);
        TreeNode n3  = new TreeNode(3);
        TreeNode n13 = new TreeNode(13);
        TreeNode n5  = new TreeNode(5);
        TreeNode n1  = new TreeNode(1);
        TreeNode n9  = new TreeNode(9);
        TreeNode n4  = new TreeNode(4);
        TreeNode n6  = new TreeNode(6);
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

        printTree(n7);
    }

    public static void printTree(TreeNode root) {

        if (root != null) {
            System.out.print(root.val + " -> ");
        }
        else {
            return;
        }
        while (root.left != null || root.right != null) {

            TreeNode curr = root;
            TreeNode prev = null;
            boolean rightChild = false;

            while (curr.left != null || curr.right != null) {

                if (curr.right != null) {  // try right ->
                    rightChild = true;
                    prev = curr;
                    curr = curr.right;
                }
                if (curr.left != null) { // try left <-
                    rightChild = false;
                    prev = curr;
                    curr = curr.left;
                }
            } // curr is now a leaf
            System.out.print(curr.val + " -> ");

            if (rightChild) {
                prev.right = null;
            }
            else {
                prev.left = null;
            }
//            System.out.println("=========================================");
//            root.printTree();
        }
    }
}
