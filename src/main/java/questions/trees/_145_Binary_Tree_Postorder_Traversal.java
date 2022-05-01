package questions.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
	1. Left
	2. Right
	3. Node
Given the root of a binary tree, return the 
post-order traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Constraints:
The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up: Recursive solution is trivial, 
could you do it iteratively?
 */
public class _145_Binary_Tree_Postorder_Traversal {

	public static void main(String[] args) {
		/***************(Tree)********************/
		TreeNode n7  = new TreeNode(7);
		TreeNode n2  = new TreeNode(2); 
		TreeNode n3  = new TreeNode(3); 
		//TreeNode n13 = new TreeNode(13);
		TreeNode n5  = new TreeNode(5);
		TreeNode n1  = new TreeNode(1); 
		TreeNode n9  = new TreeNode(9); 
		TreeNode n4  = new TreeNode(4);
		TreeNode n6  = new TreeNode(6);
		TreeNode n10 = new TreeNode(10);

		n7.left = n2;  n7.right = n3;
		/*n2.left = n13;*/ n2.right = n5;
		n3.left = n1;  n3.right = n9;
		n9.left = n4;  n9.right = n6;
		n5.left = n10;

		BTreePrinter.printNode(n7);
		/***************(Tree)********************/

		List<Integer> list;

		list = postorderTraversal(n7);
		System.out.print("(Recursive 1.0) postorderTraversal: ");
		System.out.println(list.toString());

		list = postorderTraversal2(n7);
		System.out.print("(Iterative 1.0) postorderTraversal: ");
		System.out.println(list.toString());

		list = postorderTraversal3(n7);
		System.out.print("(Iterative 2.0) postorderTraversal: ");
		System.out.println(list.toString());
		
		list = postorderTraversal4(n7);
		System.out.print("(Iterative 3.0) postorderTraversal: ");
		System.out.println(list.toString());
	}

	// -------------------------------------------------------------------------//
	// Recursive 1.0
	public static List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if(root == null) {
			return list;
		}
		dfsHelper(root, list);

		return list;
	}

	private static void dfsHelper(TreeNode curr, List<Integer> list){

		if(curr != null) { 

			dfsHelper(curr.left, list);
			dfsHelper(curr.right, list);
			list.add(curr.val);
		}
	}

	// -------------------------------------------------------------------------//
	// Iterative 1.0
	public static List<Integer> postorderTraversal2(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {

			TreeNode node = stack.pop();

			if(node != null) {
				list.add(node.val);
				stack.push(node.left);
				stack.push(node.right);
			}
		}
		Collections.reverse(list); // O(n)
		return list;
	}

	// -------------------------------------------------------------------------//
	// Iterative 2.0 (LeetCode)
	public static List<Integer> postorderTraversal3(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {

			TreeNode curr = stack.pop();

			list.add(0,curr.val);

			if(curr.left!=null) {
				stack.push(curr.left);
			}
			if(curr.right!=null) {
				stack.push(curr.right); 
			}
		}
		return list;
	}
	// -------------------------------------------------------------------------//
	// Iterative 3.0 (google)
	public static List<Integer> postorderTraversal4(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		Stack<Integer> out = new Stack<>();

		while (!stack.empty()) {

			TreeNode curr = stack.pop();
			out.push(curr.val);

			// push the left and right child of the popped node into the stack
			if (curr.left != null) {
				stack.push(curr.left);
			}
			if (curr.right != null) {
				stack.push(curr.right);
			}
		}
		while (!out.empty()) {
			list.add(out.pop());
		}
		return list;
	}


}




/*
 answer which can deal with the topological dependencies.

 public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return result;
        }
        stack.push(root);
        TreeNode cur=root;
        TreeNode pre=null;
        while (!stack.isEmpty()){
            cur=stack.peek();
            if(cur.left==null&&cur.right==null||(pre!=null&&(pre==cur.left||pre==cur.right))){
                result.add(cur.val); //deal with topological dependency
                stack.pop();
                pre=cur;
            }else {
                if (cur.right!=null){
                    stack.push(cur.right);
                }
                if(cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }
        return result;
}

*/






