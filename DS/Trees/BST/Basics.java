public class Basics{
	//http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	public boolean search(TreeNode tree, int key){
		
		//Base condition
		if(tree == null)
			return false;

		//If the key is found return true
		if(tree.getData() == key)
			return true;

		//If key is greater move right of tree else left of tree
		if(key > tree.getData())
			return search(tree.getRight(), key);
		else
			return search(tree.getLeft(), key);
	}

	//http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	public TreeNode insert(TreeNode tree, int key){

		//The new node is always inserted in the leaf
		if(tree == null){
			tree = new TreeNode(key, null, null);
			return tree;
		}

		//Smaller node is inserted to the left
		//Greater one to the right
		if(key < tree.getData())
			tree.setLeft(insert(tree.getLeft(), key));
		else 
			tree.setRight(insert(tree.getRight(), key));

		return tree;
	}


	//http://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
	public TreeNode delete(TreeNode tree, int key){

		//Base Case: If tree is empty
		if(tree == null)
			return tree;

		//Otherwise recur down the tree
		if(key<tree.getData())
			tree.setLeft(delete(tree.getLeft(), key));
		else if(key > tree.getData())
			tree.setRight(delete(tree.getRight(), key));

		//If key is same then that node needs to be deleted
		else {

			//If the node to be deleted is with one or zero child
			if(tree.getLeft() == null)
				return tree.getRight();
			else if(tree.getRight() == null)
				return tree.getLeft();

			//If is has two child get the minimum from the right subtree 
			tree.setData(getMin(tree.getRight()));

			//Delete the successor
			tree.setRight(delete(tree.getRight(), tree.getData()));
		}

		return tree;
	}

	//Utility function for getting the minimum value
	public int getMin(TreeNode tree){
		int min = tree.getData();
		while(tree.getLeft() != null){
			min = tree.getLeft().getData();
			tree = tree.getLeft();
		}

		return min;

	}
}