package questions.trees;
/*
Given the root of a binary tree, return the average value
of the nodes on each level in the form of an array. 
Answers within 10-5 of the actual answer will be accepted.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:
Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637_Average_of_Levels_in_Binary_Tree {

	public static void main(String[] args) {

		/***************(Tree)********************/
		TreeNode n7  = new TreeNode(7);
		TreeNode n2  = new TreeNode(2); 
		TreeNode n3  = new TreeNode(3); 
		TreeNode n13 = new TreeNode(0);
		TreeNode n5  = new TreeNode(5);
		TreeNode n1  = new TreeNode(1); 
		TreeNode n9  = new TreeNode(9); 
		TreeNode n4  = new TreeNode(4);
		TreeNode n6  = new TreeNode(2);
		TreeNode n10 = new TreeNode(1);

		n7.left = n2;  n7.right = n3;
		n2.left = n13; n2.right = n5;
		n3.left = n1;  n3.right = n9;
		n9.left = n4;  n9.right = n6;
		n5.left = n10;

		BTreePrinter.printNode(n7);
		/***************(Tree)********************/

		System.out.println(averageOfLevels(n7).toString());
	}
	
	
	
	// Iterative, O(n)
	public static List<Double> averageOfLevels(TreeNode root) {

		List<Double> resultList = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {

			int nodesInLevel = queue.size();
			double levelValSum = 0;

			for (int i = 1; i <= nodesInLevel; i++) {

				TreeNode tmpNode = queue.poll();
				
				levelValSum += tmpNode.val;

				if(tmpNode.left != null) {
					queue.add(tmpNode.left);
				}
				if(tmpNode.right != null) {
					queue.add(tmpNode.right);
				}
			}
			resultList.add(levelValSum / nodesInLevel);
		}
		return resultList;
	}
} // class








