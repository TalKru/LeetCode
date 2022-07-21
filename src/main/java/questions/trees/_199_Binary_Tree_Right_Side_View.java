package questions.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree,
imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:
Input: root = [1,null,3]
Output: [1,3]
Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
public class _199_Binary_Tree_Right_Side_View {

    public static void main(String[] args) {

        //==============================(Tree)==============================//
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

        n25.printTree();
        //==============================(Tree)==============================//

        List<Integer> result = rightSideView(n25);

        System.out.println("Binary_Tree_Right_Side_View: " + result);
    }

    public static List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> rightViewList = new LinkedList<>();
        Queue<TreeNode>    queue    = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                if (i == levelSize - 1) {  // for "left view" use instead if(i == 0)
                    rightViewList.add(queue.peek().val);
                }
                TreeNode tempNode = queue.poll();

                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return rightViewList;
    }

}
