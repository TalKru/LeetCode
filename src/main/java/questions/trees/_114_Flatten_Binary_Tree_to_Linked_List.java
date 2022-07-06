package questions.trees;
/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where
the right child pointer points to the next node in
the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [0]
Output: [0]

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */
public class _114_Flatten_Binary_Tree_to_Linked_List {

    public static void main(String[] args) {

        /***************(Tree)********************/
        TreeNode n25  = new TreeNode(25);
        TreeNode n15  = new TreeNode(15);
        TreeNode n10  = new TreeNode(10);
        TreeNode n4  = new TreeNode(4);
        TreeNode n12 = new TreeNode(12);
        TreeNode n22  = new TreeNode(22);
        TreeNode n18  = new TreeNode(18);
        TreeNode n24  = new TreeNode(24);
        TreeNode n50  = new TreeNode(50);
        TreeNode n70 = new TreeNode(70);
        TreeNode n90  = new TreeNode(90);
        TreeNode n31 = new TreeNode(31);
        TreeNode n35  = new TreeNode(35);
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

        n25.printTree(); // root
        /***************(Tree)********************/

        flatten(n25);

        n25.printTree();
    }

    private static TreeNode prev = null;

    /*
    If we traverse the flattened tree in the reverse way,
    we would notice that [6->5->4->3->2->1] is in (right, left, root) order of the original tree.
    So the reverse order after flattening is post order traversal
    in (right, left, root) order such [6->5->4->3->2->1].
    and then set each node's right pointer as the previous one in [6->5->4->3->2->1],
    as such the right pointer behaves similar to a link in the flattened tree(though technically,
    it's still a right child reference from the tree data structure's perspective)
    and set the left child as null before the end of one recursion by
     */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }

}
