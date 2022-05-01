package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, 
return the level order traversal of its nodes values. 
(i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */
public class _102_inary_Tree_Level_Order_Traversal {

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
		TreeNode n6  = new TreeNode(7);
		TreeNode n10 = new TreeNode(10);

		n7.left = n2;  n7.right = n3;
		n2.left = n13; n2.right = n5;
		n3.left = n1;  n3.right = n9;
		n9.left = n4;  n9.right = n6;
		n5.left = n10;

		BTreePrinter.printNode(n7);
		/***************(Tree)********************/

		List<List<Integer>> resultList = levelOrder(n7);
		
		System.out.println("level order traversal of its nodes values: ");
		for (List<Integer> list : resultList) {
			System.out.println(list.toString());
		}
	}


	// BFS
	public static List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> resultList = new ArrayList<>();

		if(root == null) { return resultList; }

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {

			int queueSize = queue.size(); 

			List<Integer> tmpList = new ArrayList<>();

			for (int i = 1; i <= queueSize; i++) {

				TreeNode tmpNode = queue.poll();

				tmpList.add(tmpNode.val);

				if(tmpNode.left != null) {
					queue.add(tmpNode.left);
				}
				if(tmpNode.right != null) {
					queue.add(tmpNode.right);
				}
			}
			resultList.add(tmpList);
		}
		return resultList;
	}

}
