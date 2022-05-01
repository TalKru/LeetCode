package questions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_BFS_Level_Separation {

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
		
		binaryTreeBFSLevelSeperation(n7);
	}
	
	public static void binaryTreeBFSLevelSeperation(TreeNode root) {
		
		if(root == null) { return; }
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 1;
		
		while(!queue.isEmpty()) {
			
			System.out.print("Level: " + level + " -> "); 	//<--(print)///////////
			
			int queueSize = queue.size(); 
			
			for (int i = 1; i <= queueSize; i++) {
				
				TreeNode tmpNode = queue.poll();
				
				System.out.print("(" + tmpNode.val + ") ");	//<--(print)///////////
				
				if(tmpNode.left != null) {
					queue.add(tmpNode.left);
				}
				if(tmpNode.right != null) {
					queue.add(tmpNode.right);
				}
			}
			System.out.println();	//<--(print)///////////
			level++;
		}
	}

}




