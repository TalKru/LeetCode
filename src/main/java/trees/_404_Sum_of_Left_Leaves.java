package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. 
A left leaf is a leaf that is the left child of another node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, 
with values 9 and 15 respectively.

Example 2:
Input: root = [1]
Output: 0

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000
 */
public class _404_Sum_of_Left_Leaves {

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

		n7.left = n2;  n7.right = n3;
		n2.left = n13; n2.right = n5;
		n3.left = n1;  n3.right = n9;
		n9.left = n4;  n9.right = n6;
		n5.left = n10;

		BTreePrinter.printNode(n7);
		/***************(Tree)********************/

		System.out.print("(Recursive 1.0) Sum Of Left Leaves = ");
		System.out.println(sumOfLeftLeaves(n7));

		System.out.print("(Recursive 2.0) Sum Of Left Leaves = ");
		System.out.println(sumOfLeftLeavesRec(n7));
		
		System.out.print("(Iterative) Sum Of Left Leaves = ");
		System.out.println(sumOfLeftLeaves2(n7));
	}

	// -------------------------------------------------------------------------//
	// Recursive 1.0
	public static int sumOfLeftLeaves(TreeNode root) {

		if(root == null) { return 0; }

		if(root.left != null) {

			if(root.left.left == null && root.left.right == null) { // leaf check

				if(root.right == null) {
					return root.left.val;
				}
				else {
					return root.left.val + sumOfLeftLeaves(root.right);
				}
			}
		}
		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
	// -------------------------------------------------------------------------//
	// Recursive 2.0
	public static int sumOfLeftLeavesRec(TreeNode root) {
		
		if(root == null) { return 0; }
		
		return recHelper(root.left, true) + recHelper(root.right, false);
	}
	private static int recHelper(TreeNode curr, boolean isLeft) {
		
		if(curr == null) { return 0; }
		
		if(curr.left == null && curr.right == null) { // leaf
			
			if(isLeft) {
				return curr.val;
			}
			else {
				return 0;
			}
		}
		else { // not leaf
			return recHelper(curr.left, true) + recHelper(curr.right, false);
		}
	}

	// -------------------------------------------------------------------------//
	// Iterative
	public static int sumOfLeftLeaves2(TreeNode root) {

		if(root == null) { return 0; }

		int leftSum = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()) {

			TreeNode curr = q.poll();

			if(curr.left != null) {
				q.add(curr.left);

				if(curr.left.left == null && curr.left.right == null) {
					leftSum += curr.left.val;
				}
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
		return leftSum;
	}
	// -------------------------------------------------------------------------//
}





















