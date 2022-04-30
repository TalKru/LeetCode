package trees;

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

		System.out.println(minDiffInBST(n7));
		System.out.println(minDiffInBST2(n7));
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










