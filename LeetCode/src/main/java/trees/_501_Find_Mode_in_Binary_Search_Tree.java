//package trees;
///*
//Given the root of a binary search tree (BST) with duplicates, 
//return all the mode(s) (i.e., the most frequently occurred element) in it.
//If the tree has more than one mode, return them in any order.
//
//Assume a BST is defined as follows:
//The left subtree of a node contains only nodes 
//with keys less than or equal to the node's key.
//The right subtree of a node contains only nodes 
//with keys greater than or equal to the node's key.
//Both the left and right subtrees must also be binary search trees.
// 
//Example 1:
//Input: root = [1,null,2,2]
//Output: [2]
//Example 2:
//Input: root = [0]
//Output: [0]
// 
//Constraints:
//The number of nodes in the tree is in the range [1, 104].
//-105 <= Node.val <= 105
//*/
//import java.util.LinkedList;
//import java.util.List;
//
//public class _501_Find_Mode_in_Binary_Search_Tree {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public static void sortedListMode(int arr[]) {
//		int counter = 1;
//		int max = 0;
//		int mode = arr[0];
//
//		for (int pass = 0; pass < arr.length - 1; pass++) { // -?1
//
//			if ( arr[pass] == arr[pass+1] ) {
//				counter++;
//
//				if ( counter > max ) {
//					max = counter;
//					mode = arr[pass];
//				}
//			} 
//			else {
//				counter = 1; // reset counter.
//			}
//		}
//	}
//
//
//	// inorder recursion
//	public static List<Integer> inorderTraversal_2(TreeNode root) {
//
//		List<Integer> list = new LinkedList<Integer>();
//		helper(root, list);
//		return list;
//	}
//
//	public static void helper(TreeNode curr, List<Integer> list){
//
//		if(curr != null) {
//
//			if(curr.left != null) {
//				helper(curr.left, list);
//			}
//			list.add(curr.val);
//
//			if(curr.right != null) {
//				helper(curr.right, list);
//			}
//		}
//		// else return
//	}
//}
