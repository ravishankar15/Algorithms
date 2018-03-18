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
            //tree.getRight().getLeft().setLeft(new TreeNode(11, null, null));
            //tree.getRight().getRight().setLeft(new TreeNode(12, null, null));



            TreeNode tree1 = new TreeNode(8,null, null);
            tree1.setLeft(new TreeNode(9, null, null));
            tree1.setRight(new TreeNode(10, null, null));
            //tree1.getLeft().setLeft(new TreeNode(2, null, null));
            //tree1.getLeft().setRight(new TreeNode(5, null, null));

            //Sum Tree
            TreeNode tree2 = new TreeNode(26, null, null);
            tree2.setLeft(new TreeNode(10, null,null));
            tree2.setRight(new TreeNode(3, null, null));
            tree2.getLeft().setLeft(new TreeNode(4, null, null));
            //tree2.getLeft().setRight(new TreeNode(6, null, null));
            tree2.getRight().setLeft(new TreeNode(3, null, null));

            TreeNode tree3 = new TreeNode(1, null, null);
            tree3.setLeft(new TreeNode(2, null, null));
            tree3.setRight(new TreeNode(3, null, null));
            tree3.getLeft().setRight(new TreeNode(4, null, null));
            tree3.getRight().setLeft(new TreeNode(5, null, null));


            TreeNode tree4 = new TreeNode(20, null, null);
            tree4.setLeft(new TreeNode(8, null, null));
            tree4.setRight(new TreeNode(22, null, null));
            tree4.getLeft().setLeft(new TreeNode(5, null, null));
            tree4.getLeft().setRight(new TreeNode(3, null, null));
            tree4.getLeft().getRight().setLeft(new TreeNode(10, null, null));
            tree4.getLeft().getRight().setRight(new TreeNode(14, null, null));
            tree4.getRight().setLeft(new TreeNode(4, null, null));
            tree4.getRight().setRight(new TreeNode(25, null, null));


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


            //TreeCalculation tc = new TreeCalculation();
            //System.out.println(tc.getHeight(tree));
            //System.out.println(tc.getSize(tree));
            //System.out.println(tc.isBalanced(tree));
            //System.out.println(tc.isBalancedOptimized(tree, new Height()));
            //System.out.println(tc.getDiameter(tree));
            //System.out.println(tc.deepLeftLeaf(tree, 0, false).getData());

            //RootToLeaf rtl = new RootToLeaf();
            //System.out.println(rtl.rootToLeafSum(tree, 10));
            //rtl.rootToLeafPath(tree, new int[1000], 0);
            //printPath(tree, rtl.maxSumPath(tree, 0));
            //System.out.println(rtl.sumNumRootToLeaf(tree, 0));
            //recursiveInOrder(rtl.removeNodesNotInPath(tree, 18));
            //System.out.println(rtl.findCloseLeaf(tree, new TreeNode[100], 8, 0));
            //System.out.println(rtl.verticalSum(tree, 0).entrySet());

            ListNode head = new ListNode(10, null);
            head.setNext(new ListNode(12, null));
            head.getNext().setNext(new ListNode(15, null));
            head.getNext().getNext().setNext(new ListNode(25, null));
            head.getNext().getNext().getNext().setNext(new ListNode(30, null));
            head.getNext().getNext().getNext().getNext().setNext(new ListNode(36, null));


            //TreeConstruction tct = new TreeConstruction();
            //recursiveInOrder(tct.buildTreeFrmInAndPre(new int[]{2,4,5,1,9,8,10}, new int[]{1,4,2,5,8,9,10}, 0, 6));
            //recursiveInOrder(tct.buildTreeFrmInAndLevel(new TreeNode(0, null, null), new int[]{2,4,5,1,9,8,10}, new int[]{1,4,8,2,5,9,10}, 0, 6));
            //recursiveInOrder(tct.buildTreeFrmPreAndPost(new int[]{1,2,4,8,9,5,3,6,7}, new int[]{8,9,4,5,2,6,7,3,1}, 0, 8));
            //recursiveInOrder(tct.buildCompleteFrmSLL(head));
            //recursiveInOrder(tct.constructFrmParArr(new int[]{1, 5, 5, 2, 2, -1, 3}));


            // TreeConnection tcon = new TreeConnection();
            // tcon.populateInorderSucc(tree, new TreeNode(-1, null, null));
            //printLevelConnection(tcon.connectLevelOrder(tree));
            /*printLevelConnection(tcon.connectLevelExtendPre(tree));
            printLevelConnection(tcon.connectLevelOptiRecur(tree));*/
            //printLevelConnection(tcon.connectLevelOpti(tree));

            TreeValidation tv = new TreeValidation();
            //System.out.println(tv.isSumTree(tree2));
            //System.out.println(tv.isFoldable(tree3.getLeft(), tree3.getRight()));
            //System.out.println(tv.isComplete(tree2));
            //System.out.println(tv.isLeafAtSameLevel(tree, 1));
            System.out.println(tv.isSubTree(tree, tree1));

            //TreeView tvi = new TreeView();
            //tvi.printLeftView(tree, 1);
            //tvi.printRightView(tree, 1);
            //System.out.println(tvi.printBottomView(tree4).entrySet());
            //System.out.println(tvi.printTopView(tree).entrySet());

            /*System.out.println();
            TreeConvertion trec = new TreeConvertion();
            printList(trec.binaryTreeToDLL(tree));*/



	}

      static void printList(TreeNode tree){
            while(tree != null){
                  System.out.print(tree.getData()+" ");
                  tree = tree.getRight();
            }
      }

      //Utility function for printing the path to the leaf
      static boolean printPath(TreeNode tree, TreeNode leaf){
            if(tree == null)
                  return false;

            if(tree == leaf || printPath(tree.getLeft(), leaf) || printPath(tree.getRight(), leaf)){
                  System.out.println(tree.getData());
                  return true;
            }

            return false;
      }

      static void recursiveInOrder(TreeNode tree){
            if(tree == null)
                  return;

            recursiveInOrder(tree.getLeft());
            System.out.print(tree.getData()+" ");
            recursiveInOrder(tree.getRight());
      }

      static void printLevelConnection(TreeNode tree){
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(tree);
            while(!queue.isEmpty()){
                  int size = queue.size();
                  //while loop for printing the level order in next next line
                  while(size-- > 0){
                        TreeNode temp = queue.poll();
                        if(temp.getLeft() != null)
                              queue.add(temp.getLeft());
                        if(temp.getRight() != null)
                              queue.add(temp.getRight());
                        System.out.print("* " + temp.getData()+" -- "+(temp.getNext() != null ? temp.getNext().getData() : temp.getNext()));
                  }
                  System.out.println();
            }

      }
}

//Utility class for height calculation problem
class Height{
      int height = 0;
}