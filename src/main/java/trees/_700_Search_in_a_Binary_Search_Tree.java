package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given the root of a 
binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val 
and return the subtree rooted with that node. 
If such a node does not exist, return null.

Example 1:
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Example 2:
Input: root = [4,2,7,1,3], val = 5
Output: []

Constraints:
The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 10^7
root is a binary search tree.
1 <= val <= 10^7
 */
public class _700_Search_in_a_Binary_Search_Tree {

	public static void main(String[] args) {

		/***************(Tree)********************/
		TreeNode n7  = new TreeNode(7);
		TreeNode n2  = new TreeNode(6); 
		TreeNode n3  = new TreeNode(8); 
		TreeNode n13 = new TreeNode(3);
		TreeNode n5  = new TreeNode(5);
		TreeNode n1  = new TreeNode(8); 
		TreeNode n9  = new TreeNode(9); 
		TreeNode n4  = new TreeNode(9);
		TreeNode n6  = new TreeNode(17);
		TreeNode n10 = new TreeNode(4);

		n7.left = n2;  n7.right = n3;
		n2.left = n13; n2.right = n5;
		n3.left = n1;  n3.right = n9;
		n9.left = n4;  n9.right = n6;
		n5.left = n10;

		BTreePrinter.printNode(n7);
		/***************(Tree)********************/

		int val = 8;
		//int val = 157;
		TreeNode searchsNode = searchBST(n7, val); // Recursive
		//TreeNode searchsNode = searchBST2(n7, val); // Iterative

		if(searchsNode != null) {
			searchsNode.printTree();
		}
		else {
			System.out.println("Node is NULL, not found.");
		}
	}


	// Recursive, O(log (n))
	public static TreeNode searchBST(TreeNode node, int val) {

		if(node == null) {
			return null;
		}
		if(node.val == val) {
			return node;
		}
		else if(val < node.val) { // go left

			return searchBST(node.left, val);
		}
		else if(val > node.val ) { // go right

			return searchBST(node.right, val);
		}
		return null;
	}



	// Iterative, O(log (n))
	public static TreeNode searchBST2(TreeNode root, int val) {

		TreeNode curr = root;
		
		while(curr != null) {
			
			if(curr.val == val) {
				return curr;
			}
			else if(val < curr.val) {
				curr = curr.left;
			}
			else if(val > curr.val) {
				curr = curr.right;
			}
		}
		return curr;
	}

} // class















