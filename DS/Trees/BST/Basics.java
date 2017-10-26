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
}