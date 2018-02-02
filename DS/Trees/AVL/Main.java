public class Main{
	public static void main(String[] args) {
		AVLTree avl = new AVLTree();
		avl.root = avl.insert(avl.root, 9);
		avl.root = avl.insert(avl.root, 5);
		avl.root = avl.insert(avl.root, 10);
		avl.root = avl.insert(avl.root, 0);
		avl.root = avl.insert(avl.root, 6);
		avl.root = avl.insert(avl.root, 11);
		avl.root = avl.insert(avl.root, -1);
		avl.root = avl.insert(avl.root, 1);
		avl.root = avl.insert(avl.root, 2);

		recursivePreOrder(avl.root);

		System.out.println();
		avl.root = avl.delete(avl.root, 10);

		recursivePreOrder(avl.root);

	}


	private static void recursivePreOrder(TreeNode tree){
		if(tree == null)
			return;
		System.out.print(tree.getData()+" ");
		recursivePreOrder(tree.getLeft());
		recursivePreOrder(tree.getRight());
	}
}