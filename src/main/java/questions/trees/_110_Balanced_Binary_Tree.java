package questions.trees;

/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees 
of every node differ in height by no more than 1.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-10^4 <= Node.val <= 10^4
 */
public class _110_Balanced_Binary_Tree {

	public static void main(String[] args) {
		/***************(Tree)********************/
		TreeNode n7  = new TreeNode(7);
		TreeNode n2  = new TreeNode(2); 
		TreeNode n3  = new TreeNode(3); 
		TreeNode n1  = new TreeNode(1); 
		TreeNode n9  = new TreeNode(9); 
		TreeNode n4  = new TreeNode(4);
		TreeNode n6  = new TreeNode(6);

		n7.left = n2;  n7.right = n3;
		n3.left = n1;  n3.right = n9;
		n9.left = n4;  n9.right = n6;

		BTreePrinter.printNode(n7);
		/***************(Tree)********************/

		System.out.println("Tree is balanced? -> " + isBalanced(n7));
	}


	//==========================================================================
	public static boolean isBalanced(TreeNode root) {

		if(root == null) { return true; }

		return height(root) != -1 ? true : false;
	}
	//==========================================================================
	public static int height(TreeNode node){

		if(node == null) { return 0; }

		int L = height(node.left);
		int R = height(node.right);

		if(L == -1 || R == -1) { return -1; }

		if(Math.abs(L - R) > 1){ return -1; }

		return 1 + Math.max(L, R);
	}
	//==========================================================================

}














