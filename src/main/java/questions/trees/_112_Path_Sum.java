package questions.trees;

import java.util.LinkedList;

/*
Given the root of a binary tree and an integer targetSum, 
return true if the tree has a root-to-leaf path such that
 adding up all the values along the path equals targetSum.
A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */
public class _112_Path_Sum {

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
		/***************(Tree)********************/

		//int targetSum = 11;
		int targetSum = 23;
		//int targetSum = 70;
		
		
		boolean res = hasPathSum(n7, targetSum);
		System.out.println("\n" + res);
		
		System.out.println();
		
		boolean res2 = hasPathSum2(n7, targetSum);
		System.out.println(res2);
	}



	public static boolean hasPathSum(TreeNode root, int targetSum) {

		if(root == null ) return false;
		return recHelper(root, targetSum, 0);
	}

	public static boolean recHelper(TreeNode curr, int targetSum, int tempSum) {

		tempSum += curr.val;

		if(curr.left == null && curr.right == null) { // leaf
			
			System.out.print(tempSum + ", ");///////////////////////
			if(tempSum == targetSum) { return true; }
			else                     { return false; }
		}
		boolean left, right;

		if(curr.left != null) {
			left = recHelper(curr.left, targetSum, tempSum);
		}
		else { left = false; }

		if(curr.right != null) {
			right = recHelper(curr.right, targetSum, tempSum);
		}
		else { right = false; }

		return left || right;
		//return recHelper(curr.left, targetSum, tempSum) || recHelper(curr.right, targetSum, tempSum);
	}

	
	
	


	// first attempt, works but uses a helper list
	public static boolean hasPathSum2(TreeNode root, int targetSum) {

		if(root == null ) return false;

		LinkedList<Integer> sumList = new LinkedList<>();

		Helper(sumList, root, 0);

		System.out.println("path sums: " + sumList.toString()); // print sum for each path ///////////////////////
		return sumList.contains(targetSum);
	}
	
	public static void Helper(LinkedList<Integer> sumList, TreeNode curr, int tempSum) {

		tempSum += curr.val;

		if(curr.left == null && curr.right == null) { // leaf
			sumList.add(tempSum); // save the path sum
			return;
		}
		if(curr.left != null) {
			Helper(sumList, curr.left, tempSum);
		}
		if(curr.right != null) {
			Helper(sumList, curr.right, tempSum);
		}
	}

}



