package questions.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree with unique values
and the values of two different nodes of the tree x and y,
return true if the nodes corresponding to the
values x and y in the tree are cousins, or false otherwise.
Two nodes of a binary tree are cousins
if they have the same depth with different parents.
Note that in a binary tree, the root node is at the depth 0,
and children of each depth k node are at the depth k + 1.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

Constraints:
The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.
 */
public class _993_Cousins_in_Binary_Tree {

    public static void main(String[] args) {

        /***************(BST Tree)********************/
        TreeNode n25 = new TreeNode(25);
        TreeNode n15 = new TreeNode(15);
        TreeNode n10 = new TreeNode(10);
        TreeNode n4 = new TreeNode(4);
        TreeNode n12 = new TreeNode(12);
        TreeNode n22 = new TreeNode(22);
        TreeNode n18 = new TreeNode(18);
        TreeNode n24 = new TreeNode(24);
        TreeNode n50 = new TreeNode(50);
        TreeNode n70 = new TreeNode(70);
        TreeNode n90 = new TreeNode(90);
        TreeNode n31 = new TreeNode(31);
        TreeNode n35 = new TreeNode(35);
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

//        int cousinA = n4.val;
//        int cousinB = n31.val;

        int cousinA = n15.val;
        int cousinB = n50.val;

        boolean res = isCousins(n25, cousinA,cousinB);

        System.out.println("Node 1: " + cousinA);
        System.out.println("Node 2: " + cousinB);
        System.out.println("is Cousins? -> " + res);
    }


    // Recursive
    public static boolean isCousins(TreeNode root, int x, int y) {

        List<TreeNode> parantlist = new LinkedList<>();
        List<Integer>  levels      = new LinkedList<>();

        treeCousins(0, root, x, y, parantlist, levels);

        if (parantlist.size() != 2 || levels.size() != 2) { // only 2 hits should happen
            return false;
        }
        if (levels.get(0) != levels.get(1)) { // nodes at different level cannot be cousins
            return false;
        }
        if (parantlist.get(0) == parantlist.get(1)) { // same parent, nodes are brothers
            return false;
        }
        return true;
    }

    private static void treeCousins(int level, TreeNode node, int x, int y, List<TreeNode> prntlst, List<Integer>  levels) {

        if (node == null) {
            return;
        }
        if (node.left != null && (node.left.val == x || node.left.val == y)) {

            prntlst.add(node);
            levels.add(level + 1);
            return;
        }
        if (node.right != null && (node.right.val == x || node.right.val == y)) {

            prntlst.add(node);
            levels.add(level + 1);
            return;
        }
        treeCousins(level + 1, node.left, x, y, prntlst, levels);
        treeCousins(level + 1, node.right, x, y, prntlst, levels);
    }

    // ======================================================================================== //
    // Iterative
    public boolean isCousins2(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean xExist  = false;
            boolean yEexist = false;

            for (int i = 0; i < size; i++) {

                TreeNode cur = queue.poll();

                if (cur.val == x) {
                    xExist = true;
                }
                if (cur.val == y) {
                    yEexist = true;
                }
                if (cur.left != null && cur.right != null) {

                    if (cur.left.val == x && cur.right.val == y) {
                        return false;
                    }
                    if (cur.left.val == y && cur.right.val == x) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (xExist && yEexist)  return true;
        }
        return false;
    }

}
