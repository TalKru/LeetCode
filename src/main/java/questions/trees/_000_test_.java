package questions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class _000_test_ {

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
		
		treeBFSlevels(n7);
	}
	
	
	public static void treeBFSlevels(TreeNode node) {
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(node);
		
		while(!q.isEmpty()) {
			
			int levelSize = q.size();
			
			for (int i = 0; i < levelSize; i++) {
				
				TreeNode curr = q.poll();
				
				System.out.print(curr.val + ", ");
				
				if(curr.left != null) {
					q.add(curr.left);
				}
				if(curr.right != null) {
					q.add(curr.right);
				}
			}
			System.out.println();
		}
	}

}









