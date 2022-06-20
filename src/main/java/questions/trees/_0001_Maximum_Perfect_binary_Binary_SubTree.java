package questions.trees;
/*
Job interview question:
Find the maximum perfect sub-tree within the given binary tree.
Return the number of it's nodes:
(nodes in perfect tree) = 2 ^ (depth) - 1
 */
public class _0001_Maximum_Perfect_binary_Binary_SubTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        node2.right = new TreeNode(4);
        root.left = node2;

        TreeNode node3 = new TreeNode(3);

        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node5.left = node7;
        node5.right = node8;

        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        node10.left = node11;

        node6.left = node9;
        node6.right = node10;

        node3.left = node5;
        node3.right = node6;
        root.right = node3;

        root.printTree();
        System.out.println(findPerfectBinaryTreeNode(root));

//        TreeNode ex2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//        System.out.println(findPerfectBinaryTreeNode(ex2));
    }


    private static int maxHeight;

    public static int findPerfectBinaryTreeNode(TreeNode root) {

        if (root == null) {
            return 0;
        }
        maxHeight = 1;
        recHelper(root);

        return (int) Math.pow(2, maxHeight) - 1;
    }

    private static int recHelper(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int heightLeft = recHelper(root.left);
        int heightRight = recHelper(root.right);

        if (heightLeft != heightRight) {
            return 1;
        }
        maxHeight = Math.max(maxHeight, heightLeft + 1);
        return heightLeft + 1;
    }

}
