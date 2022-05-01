package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Given the root of a binary tree, 
return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

////////////////////////////
In-order tree traversal:
1. Traverse Left
2. Visit Node
3. Traverse right
////////////////////////////
 */
public class _94_Binary_Tree_Inorder_Traversal {

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
		
		n7.left = n2;  
		n7.right = n3;
		n2.left = n13; 
		n2.right = n5;
		n3.left = n1;  
		n3.right = n9;
		n9.left = n4;  
		n9.right = n6;
		n5.left = n10;
		
		n7.printTree();
		/***************(Tree)********************/
		
		List<Integer> travelList_2 = inorderTraversal_2(n7); // recursive
		List<Integer> travelList = inorderTraversal(n7);   // iterative

		System.out.println("recursive: " + travelList_2.toString());
		System.out.println("iterative: " + travelList.toString());
	}
	
	// iterative 1
	public static List<Integer> inorderTraversal(TreeNode root) {
		
	    List<Integer> list = new LinkedList<>();
	    Stack<TreeNode> stack = new Stack<>();
	    
	    pushAllLeftSubBrunch(root, stack);
	    
	    while (!stack.isEmpty()) {
	    	
	        TreeNode curr = stack.pop();
	        list.add(curr.val);
	        pushAllLeftSubBrunch(curr.right, stack);
	    }
	    return list;
	}
	
	private static void pushAllLeftSubBrunch(TreeNode node, Stack<TreeNode> stack){
		
	    while (node != null) {
	        stack.push(node);
	        node = node.left;
	    }
	}
	
	// iterative 2, more complex to understand
	public static List<Integer> inorderTraversal_1(TreeNode root){

		List<Integer> list = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;

		while(curr != null || !stack.isEmpty()) {
			
			// 1. left
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			// 2. node
			curr = stack.pop();
			list.add(curr.val);
			
			// 3. right
			curr = curr.right;
		}
		return list;
	}



	// recursion
	public static List<Integer> inorderTraversal_2(TreeNode root) {

		List<Integer> list = new LinkedList<Integer>();
		helper(root, list);
		return list;
	}

	public static void helper(TreeNode curr, List<Integer> list){

		if(curr != null) {

			if(curr.left != null) {
				helper(curr.left, list);
			}
			list.add(curr.val);

			if(curr.right != null) {
				helper(curr.right, list);
			}
		}
		// else return
	}

}










