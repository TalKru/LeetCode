package questions.trees;

public class Morris_Traversal {

    // ======================================================================================== //
    public static void inorder(TreeNode root) {

        TreeNode current = root;

        while(current != null) {
            //left is null then print the node and go to right
            if (current.left == null) {

                System.out.print(current.val + ", ");
                current = current.right;
            }
            else {
                //find the predecessor.
                TreeNode predecessor = current.left;
                //To find predecessor keep going right until right node is not null or right node is not current.
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                //if right node is null then go left after establishing link from predecessor to current.
                if(predecessor.right == null){

                    predecessor.right = current;
                    current = current.left;
                }
                else{ //left is already visit. Go right after visiting current.
                    predecessor.right = null;
                    System.out.print(current.val + ", ");
                    current = current.right;
                }
            }
        }
    }
    // ======================================================================================== //

    public static void preorder(TreeNode root) {

        TreeNode current = root;

        while (current != null) {

            if(current.left == null) {

                System.out.print(current.val + ", ");
                current = current.right;
            }
            else {
                TreeNode predecessor = current.left;

                while(predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){

                    predecessor.right = current;
                    System.out.print(current.val + ", ");
                    current = current.left;
                }
                else{
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }
    // ======================================================================================== //

    public static void main(String[] args) {

        //===================(Tree)===================//
        TreeNode root  = new TreeNode(25);
        TreeNode n15   = new TreeNode(15);
        TreeNode n10   = new TreeNode(10);
        TreeNode n4    = new TreeNode(4);
        TreeNode n12   = new TreeNode(12);
        TreeNode n22   = new TreeNode(22);
        TreeNode n18   = new TreeNode(18);
        TreeNode n24   = new TreeNode(24);
        TreeNode n50   = new TreeNode(50);
        TreeNode n70   = new TreeNode(70);
        TreeNode n90   = new TreeNode(90);
        TreeNode n31   = new TreeNode(31);
        TreeNode n35   = new TreeNode(35);
        TreeNode n44   = new TreeNode(44);
        TreeNode n66   = new TreeNode(66);
        root.left = n15;
        root.right = n50;
        n15.left = n10;
        n15.right = n22;
        n10.left = n4;
        n10.right = n12;
        n22.left = n18;
        n22.right = n24;
        n50.left = n35;
        n50.right = n70;
        n35.left = n31;
        n35.right = n44;
        n70.left = n66;
        n70.right = n90;

        root.printTree();
        //===================(Tree)===================//

        System.out.print("preorder: ");
        preorder(root);
        System.out.print("\ninorder: ");
        inorder(root);
    }
}
