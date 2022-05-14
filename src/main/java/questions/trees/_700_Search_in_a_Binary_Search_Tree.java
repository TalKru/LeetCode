package questions.trees;

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

		int val = 50;
		//int val = 157;
		TreeNode searchsNode = searchBST(n25, val); // Recursive
		//TreeNode searchsNode = searchBST2(n25, val); // Iterative

		if(searchsNode != null) {
			searchsNode.printTree();
		}
		else {
			System.out.println("\033[1;31m" + "Not found.");
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















