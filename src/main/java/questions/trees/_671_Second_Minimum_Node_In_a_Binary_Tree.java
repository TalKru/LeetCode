package questions.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a non-empty special binary tree consisting of nodes with the non-negative value,
where each node in this tree has exactly two or zero sub-node.
If the node has two sub-nodes,
then this node's value is the smaller value among its two sub-nodes.
More formally,
the property root.val = min(root.left.val, root.right.val) always holds.
Given such a binary tree,
you need to output the second minimum value
in the set made of all the nodes' value in the whole tree.
If no such second minimum value exists, output -1 instead.

Example 1:
Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

Example 2:
Input: root = [2,2,2]
Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.

Constraints:
The number of nodes in the tree is in the range [1, 25].
1 <= Node.val <= 2^31 - 1
root.val == min(root.left.val, root.right.val) for each internal node of the tree.
 */
public class _671_Second_Minimum_Node_In_a_Binary_Tree {

	public static void main(String[] args) {

		/***************(special Tree)********************/
		TreeNode n2  = new TreeNode(2);
		TreeNode n22 = new TreeNode(2);
		TreeNode n5  = new TreeNode(5);
		TreeNode n55 = new TreeNode(5);
		TreeNode n7  = new TreeNode(7);
		n2.left = n22;
		n2.right = n5;
		n5.left = n55;
		n5.right = n7;

		BTreePrinter.printNode(n2);
		/***************(special Tree)********************/

		System.out.println("find Second Minimum Value: " + findSecondMinimumValue(n2));
	}

	//=========================================================================
	// Iterative BFS, O(n)
	public static int findSecondMinimumValue(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		Integer secMin = null;

		while(!queue.isEmpty()) {

			TreeNode currNode = queue.poll();

			if(currNode.val != root.val) {

				if(secMin == null) {
					secMin = currNode.val;
				}
				else {
					secMin = Math.min(secMin, currNode.val);
				}
			}
			if(currNode.left != null) {
				queue.add(currNode.left);
			}
			if(currNode.right != null) {
				queue.add(currNode.right);
			}
		}
		return (secMin == null) ? -1 : secMin;
	}
	//=========================================================================

	// root.val = min(root.left.val, root.right.val)
	public static int findSecondMinimumValue2(TreeNode root) {

		if(root.left == null) return -1;

		int l = (root.left.val  == root.val) ? findSecondMinimumValue(root.left)  : root.left.val;
		int r = (root.right.val == root.val) ? findSecondMinimumValue(root.right) : root.right.val;

		return (l == -1 || r == -1) ? Math.max(l, r) : Math.min(l, r);
	}
	//=========================================================================
}













