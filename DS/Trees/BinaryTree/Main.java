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
      	//tree.getRight().setRight(new TreeNode(10, null, null));


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


            /*TreeCalculation tc = new TreeCalculation();
            System.out.println(tc.getHeight(tree));
            System.out.println(tc.getSize(tree));
            System.out.println(tc.rootToLeafSum(tree, 10));
            System.out.println(tc.isBalanced(tree));
            System.out.println(tc.getDiameter(tree));
            tc.rootToLeafPath(tree, new int[1000], 0);*/

            TreeConstruction tct = new TreeConstruction();
            //recursiveInOrder(tct.buildTreeFrmInAndPre(new int[]{2,4,5,1,9,8,10}, new int[]{1,4,2,5,8,9,10}, 0, 6));
            //recursiveInOrder(tct.buildTreeFrmInAndLevel(new TreeNode(0, null, null), new int[]{2,4,5,1,9,8,10}, new int[]{1,4,8,2,5,9,10}, 0, 6));
            //recursiveInOrder(tct.buildTreeFrmPreAndPost(new int[]{1,2,4,8,9,5,3,6,7}, new int[]{8,9,4,5,2,6,7,3,1}, 0, 8));
	}

      static void recursiveInOrder(TreeNode tree){
            if(tree == null)
                  return;

            recursiveInOrder(tree.getLeft());
            System.out.print(tree.getData()+" ");
            recursiveInOrder(tree.getRight());
      }
}