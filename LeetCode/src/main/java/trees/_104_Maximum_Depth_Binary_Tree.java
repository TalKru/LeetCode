package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes 
along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Constraints:
The number of nodes in the tree is in the range [0, 10^4].
-100 <= Node.val <= 100
 */
public class _104_Maximum_Depth_Binary_Tree {

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

		//int maxDepth = maxDepth(n7);
		//int maxDepth = maxDepthRecursive(n7);
		System.out.println("(Iterative) Maximum_Depth_Binary_Tree: " + maxDepthIter(n7));
		System.out.println("(Recursive) Maximum_Depth_Binary_Tree: " + maxDepth(n7));
	}



	// Recursion
	public static int maxDepth(TreeNode root) {

		if(root == null) return 0;

		if(root.left == null && root.right == null) {
			return 1;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}


	// Iterative 1
	public static int maxDepthIter(TreeNode root) {

		int height = 0;

		if (root == null) return height;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			++height;
			int size = q.size();

			while (size > 0) {

				--size;
				TreeNode curr = q.poll();

				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}
		}
		return height;
	}



	/*
	// Iterative 2
	public static int maxDepth2(TreeNode root) {

		if(root == null) return 0;

		HashMap<TreeNode, Integer> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		map.put(root, 1);

		while(!queue.isEmpty()) {

			TreeNode curr = queue.poll();
			//System.out.print(curr.val + " ,");

			if(curr.left != null) {
				map.put(curr.left, map.get(curr) + 1);
				queue.add(curr.left);
			}
			if(curr.right != null) {
				map.put(curr.right, map.get(curr) + 1);
				queue.add(curr.right);
			}
		}
		int maxDepth = 0;

		for (var entry : map.entrySet()) {
			if(entry.getValue() > maxDepth) {
				maxDepth = entry.getValue();
			}
		}
		return maxDepth;
	}
	 */



	/*
	public static int maxDepth(TreeNode root) {

		if(root == null) return 0;

		LinkedList<Integer> list = new LinkedList<>();

		helper(root, list, 1);

		int max = 0;

		for (Integer n : list) {
			if(n > max) {
				max = n;
			}
		}
		return max;
	}
	public static void helper(TreeNode curr, LinkedList<Integer> list, int depth) {

		if(curr.left == null && curr.right == null) {
			list.add(depth);
			return;
		}
		if(curr.left != null) {
			helper(curr.left, list, depth + 1);
		}
		if(curr.right != null) {
			helper(curr.right, list, depth + 1);
		}
	}
	 */
}













