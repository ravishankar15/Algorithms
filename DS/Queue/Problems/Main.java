public class Main{
	public static void main(String[] args) {

		ListNode head = new ListNode(10, null);
		head.setNext(new ListNode(12, null));
		head.getNext().setNext(new ListNode(15, null));
	    head.getNext().getNext().setNext(new ListNode(25, null));
	    head.getNext().getNext().getNext().setNext(new ListNode(30, null));
	    head.getNext().getNext().getNext().getNext().setNext(new ListNode(36, null));


	    TreeNode tree = new TreeNode(1, null, null);
		tree.setLeft(new TreeNode(2, null, null));
        tree.setRight(new TreeNode(3, null, null));
      	tree.getLeft().setLeft(new TreeNode(4, null, null));
      	tree.getLeft().setRight(new TreeNode(5, null, null));
      	tree.getRight().setRight(new TreeNode(10, null, null));


      	PetrolPump[] arr = {new PetrolPump(4, 6),
                            new PetrolPump(6, 5),
                            new PetrolPump(7, 3),
                        	new PetrolPump(4, 5)};

	    //Standard std = new Standard();
	    //inOrder(std.getBinaryTree(head)); //Linked List representation to Binary Tree
	    //System.out.println(std.replaceAlgo(new int[] {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2}, 4));
	    //System.out.println(std.isCompleteBT(tree)); //To check if the given tree is complete

	    // SlidingWindow sw = new SlidingWindow();
	    // sw.maximum(new int[] {1, 2, 3, 1, 4, 5, 2, 3, 6}, 3);

           // CircularTour ct = new CircularTour();
           // System.out.println(ct.getStartOfTour(arr, arr.length));
           // System.out.println(ct.getStartOfTourQ(arr, arr.length));

        // RottenOranges ro = new RottenOranges();
        // System.out.println(ro.getMinTime(new int[][]{{2, 1, 0, 2, 1},
        //                 {1, 0, 1, 2, 1},
        //                 {1, 0, 0, 2, 1}}, 3, 5));

         CharCountProblem ccp = new CharCountProblem();
         //System.out.println(ccp.getMinValue("abbccc", 2)); 
         ccp.firstNonRepeat("aabc");

	}


	public static void inOrder(TreeNode tree){
		if(tree == null)
			return;

		inOrder(tree.getLeft());
		System.out.print(tree.getData()+" ");
		inOrder(tree.getRight());
	}
}