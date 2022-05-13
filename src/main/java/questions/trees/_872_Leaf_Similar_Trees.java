package questions.trees;

import java.util.LinkedList;
import java.util.List;

/*
Consider all the leaves of a binary tree, from left to right order,
the values of those leaves form a leaf value sequence.

For example, in the given tree above,
the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar
if their leaf value sequence is the same.

Return true if and only if the two given trees
with head nodes root1 and root2 are leaf-similar.

Example 1:
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4],
root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

Example 2:
Input:
root1 = [1,2,3],
root2 = [1,3,2]
Output: false

Constraints:
The number of nodes in each tree will be in the range [1, 200].
Both of the given trees will have values in the range [0, 200].
 */
public class _872_Leaf_Similar_Trees {

    public static void main(String[] args) {

        /***************(Tree)********************/
        // tree 1
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n13 = new TreeNode(13);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n9 = new TreeNode(9);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n10 = new TreeNode(100);
        n7.left = n2;
        n7.right = n3;
        n2.left = n13;
        n2.right = n5;
        n3.left = n1;
        n3.right = n9;
        n9.left = n4;
        n9.right = n6;
        n5.left = n10;
        // tree 2
        TreeNode n79 = new TreeNode(7);
        TreeNode n29 = new TreeNode(2);
        TreeNode n39 = new TreeNode(3);
        TreeNode n139 = new TreeNode(13);
        TreeNode n59 = new TreeNode(5);
        TreeNode n19 = new TreeNode(1);
        TreeNode n99 = new TreeNode(9);
        TreeNode n49 = new TreeNode(4);
        TreeNode n69 = new TreeNode(6);
        TreeNode n109 = new TreeNode(10);
        n79.left = n29;
        n79.right = n39;
        n29.left = n139;
        n29.right = n59;
        n39.left = n19;
        n39.right = n99;
        n99.left = n49;
        n99.right = n69;
        n59.left = n109;

        n7.printTree();
        n79.printTree();
        /***************(Tree)********************/

        System.out.println("Do trees have the same leaves?");
        System.out.println("(With the same left to right order))");
        System.out.println("Result: " + leafSimilar(n7, n79));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null){
            return false;
        }
        List<Integer> leafs1 = new LinkedList<>();
        List<Integer> leafs2 = new LinkedList<>();

        leftToRightLeafs(root1, leafs1);
        leftToRightLeafs(root2, leafs2);

        return leafs1.equals(leafs2);
    }

    // InOrder traversal with leaf capturing
    private static void leftToRightLeafs(TreeNode node, List<Integer> leafs){

        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            leafs.add(node.val);
        }
        leftToRightLeafs(node.left, leafs);
        leftToRightLeafs(node.right, leafs);
    }
}
