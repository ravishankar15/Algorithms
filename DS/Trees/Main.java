import java.util.*;
public class Main{
	public static void main(String[] args) {

		/*   TreeNode tree:

		         	   1	
			      / 	\
			    4		   8
			 /   \	 /	 \
		      2	5	 9	 10


		*/

		TreeNode tree = new TreeNode(1, null, null);
		tree.setLeft(new TreeNode(4, null, null));
        	tree.setRight(new TreeNode(8, null, null));
      	tree.getLeft().setLeft(new TreeNode(2, null, null));
      	tree.getLeft().setRight(new TreeNode(5, null, null));
      	tree.getRight().setLeft(new TreeNode(9, null, null));
      	tree.getRight().setRight(new TreeNode(10, null, null));


      	//Traversal of Tree
      	//TreeTraversal tt = new TreeTraversal();
      	//tt.recursiveInOrder(tree); //Prints in InOrder(Left - Root - Right)
      	//tt.recursivePreOrder(tree); //Prints in PreOrder(Root - Left - Right)
      	//tt.recursivePostOrder(tree); //Prints in PostOrder(Left - Right - Root)
      	//tt.printLevelOrder(tree); //Prints in LevelOrder
      	//tt.stackInOrder(tree); //Prints the InOrder using stack
      	//System.out.println();
      	//tt.stackPreOrder(tree);
      	//tt.stackPostOrder(tree);


            TreeCalculation tc = new TreeCalculation();
            /*System.out.println(tc.getHeight(tree));
            System.out.println(tc.getSize(tree));
            System.out.println(tc.rootToLeafSum(tree, 10));
            System.out.println(tc.isBalanced(tree));
            System.out.println(tc.getDiameter(tree));*/
            tc.rootToLeafPath(tree, new int[1000], 0);
	}
}