package trees;
/*
Given the roots of two binary trees root and subRoot, 
return true if there is a subtree of root with the same 
structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists 
of a node in tree and all of this node's descendants. 
The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

Constraints:
The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 10^4
-104 <= subRoot.val <= 10^4
 */
public class _572_Subtree_of_Another_Tree {

	public static void main(String[] args) {

		/***************(Tree)********************/
		// tree 
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2); 
		TreeNode n3 = new TreeNode(3); 
		TreeNode n13 = new TreeNode(13);
		TreeNode n5 = new TreeNode(5);
		TreeNode n1 = new TreeNode(1); 
		TreeNode n9 = new TreeNode(9); 
		TreeNode n4 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n10 = new TreeNode(10);
		n7.left = n2;
		n7.right = n3;
		n2.left = n13;
		n2.right = n5;
		n3.left = n1;
		n3.right = n9;
		n9.left = n4;
		n9.right = n6;
		n5.left = n10;

		// sub tree 
		TreeNode n39 = new TreeNode(3); 
		TreeNode n19 = new TreeNode(1); 
		TreeNode n99 = new TreeNode(9); 
		TreeNode n49 = new TreeNode(4);
		TreeNode n69 = new TreeNode(6);
		n39.left = n19;
		n39.right = n99;
		n99.left = n49;
		n99.right = n69;

		n7.printTree();
		n39.printTree();
		/***************(Tree)********************/
		
		System.out.println("is subtree: " + isSubtree(n7, n39));
	}
	
	
	
	// Recursive
	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

		if(root == null || subRoot == null) {
			return false;
		}
		if(isSameTree(root, subRoot)) {
			return true;
		}
		boolean lSub = isSubtree(root.left, subRoot);
		boolean rSub = isSubtree(root.right, subRoot);
		
		return (lSub || rSub);
	}
	
	// checks is 2 input trees are identical
	private static boolean isSameTree(TreeNode p, TreeNode q) { 
		
		if(p == null ^ q == null) {
			return false;
		}
		if(p == null && q == null) {
			return true;
		}
		if(p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
}









