package trees;

import java.util.LinkedList;
import java.util.Queue;

/*

 */
public class _671_Second_Minimum_Node_In_a_Binary_Tree {

	public static void main(String[] args) {

		/***************(Tree)********************/
		TreeNode n7  = new TreeNode(7);
		TreeNode n2  = new TreeNode(2); 
		TreeNode n3  = new TreeNode(30); 
		TreeNode n13 = new TreeNode(13);
		TreeNode n5  = new TreeNode(5);
		TreeNode n1  = new TreeNode(10); 
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

		System.out.println(findSecondMinimumValue(n7));
	}

	//=========================================================================
	// Iterative BFS, O(n)
	public static int findSecondMinimumValue2(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		//int minVal = Integer.MAX_VALUE; 
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
	public static int findSecondMinimumValue(TreeNode root) {

		if(root.left == null) return -1;

		int l = root.left.val  == root.val ? findSecondMinimumValue(root.left)  : root.left.val;
		int r = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;

		return l == -1 || r == -1 ? Math.max(l, r) : Math.min(l, r);
	}
	//=========================================================================
}













