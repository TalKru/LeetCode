package trees;

import java.util.Stack;

/*
Given the root of a binary tree, 
check whether it is a mirror of itself 
(i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 */
public class _101_Symmetric_Tree {

	public static void main(String[] args) {
		
		/***************(Tree)********************/
		TreeNode n7  = new TreeNode(1);
		TreeNode n2  = new TreeNode(4); 
		TreeNode n3  = new TreeNode(4); 
		TreeNode n13 = new TreeNode(13);
		TreeNode n5  = new TreeNode(5);
		TreeNode n1  = new TreeNode(5); 
		TreeNode n9  = new TreeNode(13); 
		//TreeNode n4  = new TreeNode(4);
		//TreeNode n6  = new TreeNode(6);
		//TreeNode n10 = new TreeNode(10);

		n7.left = n2;  n7.right = n3;
		n2.left = n13; n2.right = n5;
		n3.left = n1;  n3.right = n9;
		//n9.left = n4;  n9.right = n6;
		//n5.left = n10;

		BTreePrinter.printNode(n7);
		/***************(Tree)********************/

		System.out.println("(Recursive) is Symmetric tree? -> " + isSymmetric(n7));
		System.out.println("(Iterative) is Symmetric tree? -> " + isSymmetric2(n7));
	}

	//===========================================================================//
	// Recursive
	public static boolean isSymmetric(TreeNode root) {

		if(root == null) return true;

		return isSym(root.left, root.right);
	}
	public static boolean isSym(TreeNode left, TreeNode right) {

		if(left == null && right == null ) {
			return true;
		}
		if(left == null ^ right == null) { // XOR, if exactly one is null
			return false;
		}
		if(left.val != right.val) {
			return false;
		}
		return isSym(left.left, right.right) && isSym(left.right, right.left);
	}
	//===========================================================================//

	// Iterative
	public static boolean isSymmetric2(TreeNode root) {

		if (root == null) return true;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);

		while (!stack.empty()) {

			TreeNode n1 = stack.pop(), n2 = stack.pop();

			if (n1 == null && n2 == null) continue;
			if (n1 == null || n2 == null || n1.val != n2.val) return false;

			stack.push(n1.left);
			stack.push(n2.right);
			stack.push(n1.right);
			stack.push(n2.left);
		}
		return true;
	}
	//===========================================================================//
}






