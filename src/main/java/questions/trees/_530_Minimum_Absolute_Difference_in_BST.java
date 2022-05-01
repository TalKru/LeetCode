package questions.trees;

import java.util.List;

/*
Given the root of a Binary Search Tree (BST), 
return the minimum absolute difference between 
the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 10^4].
0 <= Node.val <= 10^5
 */
public class _530_Minimum_Absolute_Difference_in_BST {

	public static void main(String[] args) {

		/***************(Tree)********************/
		TreeNode n7  = new TreeNode(7);
		TreeNode n2  = new TreeNode(6); 
		TreeNode n3  = new TreeNode(10); 
		TreeNode n13 = new TreeNode(3);
		TreeNode n5  = new TreeNode(4);
		TreeNode n1  = new TreeNode(9); 
		TreeNode n9  = new TreeNode(19); 
		//TreeNode n4  = new TreeNode(4);
		//TreeNode n6  = new TreeNode(6);
		//TreeNode n10 = new TreeNode(10);

		n7.left = n2;  
		n7.right = n3;
		n2.left = n13; 
		n2.right = n5;
		n3.left = n1;  
		n3.right = n9;
		//n9.left = n4;  
		//n9.right = n6;
		//n5.left = n10;

		n7.printTree();
		/***************(Tree)********************/

		System.out.println("minimum absolute difference between \r\n"
				+ "the values of any two different nodes in the tree :" + getMinimumDifference(n7));
	}
	
	
	
	// slow - based on call for class: _94_Binary_Tree_Inorder_Traversal
	public static int getMinimumDifference(TreeNode root) {

		List<Integer> travelList = _94_Binary_Tree_Inorder_Traversal.inorderTraversal(root);
		int minDif = Integer.MAX_VALUE;
		
		for (int i = 1; i < travelList.size(); i++) {
			
			int currDif = Math.abs(travelList.get(i) - travelList.get(i-1));
			
			minDif = Math.min(minDif, currDif);
		}
		return minDif;
	}
	
	
	
	// fast - LeetCode
	int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference2(TreeNode root) {
    	
        if (root == null) {
        	return min;
        }
        getMinimumDifference(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }

}








