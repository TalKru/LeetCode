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

    public static TreeNode buildTree(Integer[] arr) {

        TreeNode root = null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode t = arr[i] == null ? null : new TreeNode(arr[i]);

        root = t;
        q.add(root);
        i++;

        while (!q.isEmpty() && i < arr.length) {

            TreeNode t1 = q.poll();

            if (t1 != null) {
                t1.left = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.left);
                i++;

                if (i >= arr.length) {
                    break;
                }
                t1.right = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.right);
                i++;
            }
        }
        return root;
    }
}
