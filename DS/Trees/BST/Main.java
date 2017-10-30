public class Main{
	public static void main(String[] args) {

	  TreeNode tree = new TreeNode(80, null, null);

      tree.setLeft(new TreeNode(40, null, null));
      tree.setRight(new TreeNode(120, null, null));

      tree.getLeft().setLeft(new TreeNode(20, null, null));
      tree.getLeft().setRight(new TreeNode(60, null, null));
      tree.getRight().setLeft(new TreeNode(100, null, null));
      tree.getRight().setRight(new TreeNode(140, null, null));

      tree.getLeft().getLeft().setLeft(new TreeNode(10, null, null));
      tree.getLeft().getLeft().setRight(new TreeNode(30, null, null));
      tree.getLeft().getRight().setLeft(new TreeNode(50, null, null));
      tree.getLeft().getRight().setRight(new TreeNode(70, null, null));

      tree.getRight().getLeft().setLeft(new TreeNode(90, null, null));
      tree.getRight().getLeft().setRight(new TreeNode(110, null, null));
      tree.getRight().getRight().setLeft(new TreeNode(130, null, null));
      tree.getRight().getRight().setRight(new TreeNode(150, null, null));




		//Basics b = new Basics();
		//System.out.println(b.search(tree, 30));
		//recursiveInOrder(b.insert(b.insert(b.insert(b.insert(b.insert(b.insert(new TreeNode(50, null, null), 30), 20),40),70),60),80));
            //recursiveInOrder(b.delete(tree, 40));

            /*TreeConstruction tc = new TreeConstruction();
            recursiveInOrder(tc.buildTreeFromPre(new int[]{10, 5, 1, 7, 40, 50}, 10, new Index(), Integer.MIN_VALUE, Integer.MAX_VALUE));
            recursiveInOrder(tc.buildTreeFromPreStack(new int[]{10, 5, 1, 7, 40, 50}));*/

            TreeCalculation tcal = new TreeCalculation();
            System.out.println(tcal.isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}


	public static void recursiveInOrder(TreeNode tree){
		if(tree == null)
			return;

		recursiveInOrder(tree.getLeft());
		System.out.print(tree.getData()+" ");
		recursiveInOrder(tree.getRight());
	}
}

//Utility class for the tree construction problem
class Index{
      int index = 0;
}