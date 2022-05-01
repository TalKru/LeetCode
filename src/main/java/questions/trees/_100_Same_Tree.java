package questions.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the roots of two binary trees p and q,
write a function to check if they are the same or not.
Two binary trees are considered the same if they
are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:
The number of nodes in both trees is in the range [0, 100].
-10^4 <= Node.val <= 10^4
 */
public class _100_Same_Tree {

	public static void main(String[] args) {
		
		/***************(Tree)********************/
		// tree 1
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2); 
		TreeNode n3 = new TreeNode(3); 
		TreeNode n13 = new TreeNode(13);
		TreeNode n5 = new TreeNode(5);
		TreeNode n1 = new TreeNode(1); 
		TreeNode n9 = new TreeNode(9); 
		TreeNode n4 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n10 = new TreeNode(10);
		n7.left = n2;
		n7.right = n3;
		n2.left = n13;
		n2.right = n5;
		n3.left = n1;
		n3.right = n9;
		n9.left = n4;
		n9.right = n6;
		n5.left = n10;

		// tree 2
		TreeNode n79 = new TreeNode(7);
		TreeNode n29 = new TreeNode(2); 
		TreeNode n39 = new TreeNode(3); 
		TreeNode n139 = new TreeNode(13);
		TreeNode n59 = new TreeNode(5);
		TreeNode n19 = new TreeNode(1); 
		TreeNode n99 = new TreeNode(9); 
		TreeNode n49 = new TreeNode(4);
		TreeNode n69 = new TreeNode(6);
		TreeNode n109 = new TreeNode(10);
		n79.left = n29;
		n79.right = n39;
		n29.left = n139;
		n29.right = n59;
		n39.left = n19;
		n39.right = n99;
		n99.left = n49;
		n99.right = n69;
		n59.left = n109;

		n7.printTree();
		n79.printTree();
		/***************(Tree)********************/
		
		//boolean res = isSameTree(n7, n79);
		System.out.println("(Recursive) Trees identical? -> " + isSameTree(n7, n79) );
		System.out.println("(Iterative) Trees identical? -> " + isSameTree2(n7, n79) );

	} // main



	//====================================================================================//
	// Recursive
	public static boolean isSameTree(TreeNode p, TreeNode q) { 

		if(p == null ^ q == null) {
			return false;
		}
		if(p == null && q == null) {
			return true;
		}
		if(p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	//====================================================================================//
	
	// Iterative
	public static boolean isSameTree2(TreeNode p, TreeNode q) { 

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(p);
		queue.add(q);

		while(!queue.isEmpty()){

			TreeNode tree1node = queue.poll();
			TreeNode tree2node = queue.poll();

			if(tree1node == null && tree2node == null){
				continue;
			}
			if(tree1node == null || tree2node == null || tree1node.val != tree2node.val){
				return false;
			}
			queue.add(tree1node.left);
			queue.add(tree2node.left);

			queue.add(tree1node.right);
			queue.add(tree2node.right);
		}
		return true;
	}
	//====================================================================================//
}














