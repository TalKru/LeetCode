package questions.trees;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/*
Pre-order, NLR
1. Visit the current node (in the figure: position red).
2. Recursively traverse the current node's left subtree.
3. Recursively traverse the current node's right subtree.

Given the root of a binary tree, return the preorder traversal of its nodes' values.


Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class _144_Binary_Tree_Preorder_Traversal {

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

		List<Integer> list = preorderTraversal(n7);
		System.out.print("(Recursive) preorderTraversal: ");
		System.out.println(list.toString());

		List<Integer> list2 = preorderTraversal2(n7);
		System.out.print("(Iterative) preorderTraversal: ");
		System.out.println(list2.toString());

	}

	// -------------------------------------------------------------------------//
	// Recursive
	public static List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if(root == null) { return list; }
		
		recHelper(root, list);
		
		return list;
	}

	private static void recHelper(TreeNode curr, List<Integer> list){

		if(curr == null) { return; }

		list.add(curr.val);
		recHelper(curr.left, list);
		recHelper(curr.right, list);
	}

	// -------------------------------------------------------------------------//
	// Iterative
	public static List<Integer> preorderTraversal2(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {

			TreeNode curr = stack.pop();

			list.add(curr.val);
			/*
			Note: the idea to use stack is due for this DFS nature traversal.
			But pushing into the stack must be done in reverse logic of the 
			pre-order algorithm: 
			
			1) Visit the current ->(1) 
			2) Visit left        ->(3)
			3) Visit right       ->(2)
			
			Because the stack pop's in reverse way of our traversal logic
			*/
			if(curr.right != null) { stack.push(curr.right); }
			if(curr.left  != null) { stack.push(curr.left); }
		}
		return list;
	}
	// -------------------------------------------------------------------------//
}










