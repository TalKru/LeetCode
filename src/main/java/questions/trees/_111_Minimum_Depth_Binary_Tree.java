package questions.trees;
/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest 
path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5

Constraints:
The number of nodes in the tree is in the range [0, 10^5].
-1000 <= Node.val <= 1000
 */
public class _111_Minimum_Depth_Binary_Tree {

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

		/*n7.left = n2;*/  n7.right = n3;
		n2.left = n13; n2.right = n5;
		n3.left = n1;  n3.right = n9;
		n9.left = n4;  n9.right = n6;
		n5.left = n10;

		BTreePrinter.printNode(n7);
		/***************(Tree)********************/

		System.out.println("Minimum_Depth_Binary_Tree: " + minDepth(n7));
	}


	// Recursive
	public static int minDepth(TreeNode root) {

		if(root == null) return 0;

		if(root.left == null && root.right == null) {
			return 1;
		}
		int R = Integer.MAX_VALUE;
		int L = Integer.MAX_VALUE;

		if(root.left != null) {
			R = 1 + minDepth(root.left);
		}
		if(root.right != null) {
			L =  1 + minDepth(root.right);
		}
		return Math.min(L, R);
	}
	
	/*
	// questions.other solutions (not mine)
	public int minDepth(TreeNode root) {
	    if (root == null) return 0;
	    int L = minDepth(root.left); 
	    int R = minDepth(root.right);
	    return 1 + (Math.min(L, R) > 0 ? Math.min(L, R) : Math.max(L, R));
	}
	public int minDepth(TreeNode root) {
	    if (root == null) return 0;
	    int L = minDepth(root.left); 
	    int R = minDepth(root.right); 
	    int m = Math.min(L, R);
	    return 1 + (m > 0 ? m : Math.max(L, R));
	}
	public int minDepth(TreeNode root) {
	    if (root == null) return 0;
	    int L = minDepth(root.left); 
	    int R = minDepth(root.right);
	    return L<R && L>0 || R<1 ? 1+L : 1+R;
	}
	public int minDepth(TreeNode root) { // fastest
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }
	*/
}













