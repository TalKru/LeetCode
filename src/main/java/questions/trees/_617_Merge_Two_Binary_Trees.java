package questions.trees;
/*
You are given two binary questions.trees root1 and root2.
Imagine that when you put one of them to cover the questions.other,
some nodes of the two questions.trees are overlapped while the
others are not. 
You need to merge the two questions.trees into a new binary tree.
The merge rule is that if two nodes overlap, 
then sum node values up as the new value of the merged node. 
Otherwise, the NOT null node will be used as the node of the new tree.

"Return the merged tree."

Note: The merging process must start from the root nodes of both questions.trees.

Example 1:
Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]

Example 2:
Input: root1 = [1], root2 = [1,2]
Output: [2,2]

Constraints:
The number of nodes in both questions.trees is in the range [0, 2000].
 */
public class _617_Merge_Two_Binary_Trees {

	public static void main(String[] args) {

		/***************(Tree)********************/
		// tree 1
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2); 
		TreeNode n3 = new TreeNode(3); 
		//TreeNode n13 = new TreeNode(13);
		TreeNode n5 = new TreeNode(5);
		TreeNode n1 = new TreeNode(1); 
		TreeNode n9 = new TreeNode(9); 
		TreeNode n4 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n10 = new TreeNode(10);
		n7.left = n2;
		n7.right = n3;
		//n2.left = n13;
		//n2.right = n5;
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
		//n79.right = n39;
		n29.left = n139;
		n29.right = n59;
		n39.left = n19;
		n39.right = n99;
		n99.left = n49;
		n99.right = n69;
		n59.left = n109;
		System.out.println("Tree 1:");
		n7.printTree();
		System.out.println("Tree 2:");
		n79.printTree();
		/***************(Tree)********************/
		
		System.out.println("Merged questions.trees:");
		TreeNode n100 = mergeTrees(n7, n79);
		n100.printTree();
	}

	// will build merged tree on top tree 1
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		if(t1 == null) {
			return t2;
		}
		if(t2 == null) {
			return t1;
		}
		TreeNode node = new TreeNode(t1.val + t2.val);
		
		node.left =  mergeTrees(t1.left, t2.left);
		node.right = mergeTrees(t1.right, t2.right);
		
		return node;
	}
	
}







