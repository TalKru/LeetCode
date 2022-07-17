package questions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {} // default

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

//    TreeNode(Integer[] arr) {
//        TreeNode root = buildTree(arr);
//        this.val = root.val;
//        this.left = root.left;
//        this.right = root.right;
//    }

    public void printTree() {
        BTreePrinter.printNode(this);
    }

    /*
    Construct binary tree from Integer array as input.
    returns the root of the built tree.
     */
    public static TreeNode buildTree(Integer[] arr) {

        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        TreeNode root = (arr[i] == null) ? null : new TreeNode(arr[i]);

        queue.add(root);
        i++;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode tempNode = queue.poll();

            if (tempNode != null) {
                tempNode.left = (arr[i] == null) ? null : new TreeNode(arr[i]);
                queue.add(tempNode.left);
                i++;

                if (i >= arr.length) {
                    break;
                }
                tempNode.right = (arr[i] == null) ? null : new TreeNode(arr[i]);
                queue.add(tempNode.right);
                i++;
            }
        }
        return root;
    }
}
