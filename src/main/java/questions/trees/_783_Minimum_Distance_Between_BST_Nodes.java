package questions.trees;

import java.util.LinkedList;
import java.util.List;

/*
 Given the root of a Binary Search Tree (BST), 
 return the minimum difference between the values 
 of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1
Example 2:

Input: root = [1,0,48,null,null,12,49]
Output: 1
 
Constraints:
The number of nodes in the tree is in the range [2, 100].
0 <= Node.val <= 10^5
*/

public class _783_Minimum_Distance_Between_BST_Nodes {

	public static void main(String[] args) {

		/***************(BST Tree)********************/
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

		n25.printTree(); // root of BST
		/***************(BST Tree)********************/

		System.out.println("(Iterative) min diff between any 2 nodes: " + minDiffInBST(n25));
		System.out.println("(Recursive) min diff between any 2 nodes: " + minDiffInBST2(n25));
	}
	
	//-------------------------------------------------------------------------//
	// Iterative O(n) + Recursive O(n)
	private static List<Integer> list;
	
	public static int minDiffInBST(TreeNode root) {
		
		list = new LinkedList<Integer>();
		
		inOrderDFS(root);
		
		int minVal = Integer.MAX_VALUE;
		
		for (int i = 0; i < list.size() - 1; i++) {
			
			int dif = list.get(i+1) - list.get(i);
			
			minVal = Math.min(minVal, dif);
		}
		return minVal;
	}
	
	private static void inOrderDFS(TreeNode node) {
		
		if(node == null) {
			return;
		}
		inOrderDFS(node.left);
		list.add(node.val);
		inOrderDFS(node.right);
	}
	//-------------------------------------------------------------------------//
	//Recursive O(n)
	private static Integer minVal;
	private static Integer prevNodeVal;
	
	public static int minDiffInBST2(TreeNode root) {
		
		minVal = Integer.MAX_VALUE;
		prevNodeVal = null;
		
		inOrderDFSRec(root);
		return minVal;
	}
	
	private static void inOrderDFSRec(TreeNode node) {
		
		if(node == null) {
			return;
		}
		inOrderDFSRec(node.left);
		
		//System.out.println(prevNodeVal + " - "  + node.val);
		
		if(prevNodeVal != null) {
			minVal = Math.min(minVal, node.val - prevNodeVal);
		}
		prevNodeVal = node.val;
		
		inOrderDFSRec(node.right);
	}
	//-------------------------------------------------------------------------//
}










