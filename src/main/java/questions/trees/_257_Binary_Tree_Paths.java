package questions.trees;

import java.util.LinkedList;
import java.util.List;

/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:
Input: root = [1]
Output: ["1"]

Constraints:
The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
 */
public class _257_Binary_Tree_Paths {

    public static void main(String[] args) {

        //====================(Tree)====================//
        TreeNode root = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n13 = new TreeNode(13);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n9 = new TreeNode(9);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n10 = new TreeNode(10);
        root.left = n2;
        root.right = n3;
        n2.left = n13;
        n2.right = n5;
        n3.left = n1;
        n3.right = n9;
        n9.left = n4;
        n9.right = n6;
        n5.left = n10;

        root.printTree();
        //====================(Tree)====================//

        List<String> list = binaryTreePaths(root);

        System.out.println(list);
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }
        List<String> pathList = new LinkedList<>();

        pathsToLeafs(root, "", pathList);

        return pathList;
    }

    private static void pathsToLeafs(TreeNode node, String currentPath, List<String> pathList) {

        if (node.left == null && node.right == null) {

            currentPath += String.valueOf(node.val);

            pathList.add(currentPath);
            return;
        }
        currentPath += String.valueOf(node.val) + "->";

        if (node.left != null) {
            pathsToLeafs(node.left, currentPath, pathList);
        }
        if (node.right != null) {
            pathsToLeafs(node.right, currentPath, pathList);
        }
    }

}
