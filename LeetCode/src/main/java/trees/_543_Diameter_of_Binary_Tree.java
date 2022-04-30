package trees;

import java.util.HashMap;


/*
Given the root of a binary tree, return the length 
of the diameter of the tree.
The diameter of a binary tree is the length of the longest path
between any two nodes in a tree. This path may or may
not pass through the root.
The length of a path between two nodes is represented 
by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1

Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-100 <= Node.val <= 100
 */
public class _543_Diameter_of_Binary_Tree {

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
		TreeNode n98 = new TreeNode(98);
		TreeNode n97 = new TreeNode(97);

		n1.left = n97;
		n97.right = n98;
		
		//n7.left = n2;  
		n7.right = n3;
		//n2.left = n13; 
		//n2.right = n5;
		n3.left = n1;  
		n3.right = n9;
		n9.left = n4;  
		n9.right = n6;
		n5.left = n10;

		BTreePrinter.printNode(n7);
		/***************(Tree)********************/
		
		System.out.println("NOTE: diameter may not go thought the root!");
		
		int diameter = diameterOfBinaryTree(n7);
		System.out.println("Diameter Of Binary Tree = " + diameter);

		System.out.println("Diameter Of Binary Tree = " + diameterOfBinaryTree2(n7));
	}

	//================================================================================//
	/*
	3 cases occur while finding diameter:

	-the maximum diameter lies in left sub tree entirely (as in the below image)
	-the maximum diameter lies in right sub tree entirely
	-the maximum diameter passes through the root node(height of lhs + height of rhs + 2)
	 */
	//================================================================================//
	// slow
	public static int diameterOfBinaryTree(TreeNode root) {

		int res = 0;
		if(root == null) return res;

		int curr = maxDepth(root.left) + maxDepth(root.right);
		int left = diameterOfBinaryTree(root.left);
		int right = diameterOfBinaryTree(root.right);

		return Math.max(curr, Math.max(left, right));
	}

	private static int maxDepth(TreeNode root){

		if(root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}


	//================================================================================//
	// fast
	static int diameter = 0; // global

	public static int diameterOfBinaryTree2(TreeNode root) {
		
		maxDepth2(root);
		return diameter;
	}

	private static int maxDepth2(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int left = maxDepth2(root.left);
		int right = maxDepth2(root.right);

		diameter = Math.max(diameter, left + right);

		return Math.max(left, right) + 1;
	}
	//================================================================================//

}














