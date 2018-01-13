//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/
public class CheckHeap{

	private int count;
	public boolean isBinaryTreeAHeap(TreeNode tree){
		count = countNodes(tree);
		return isComplete(tree, 0) && isHeap(tree);
	}

	private int countNodes(TreeNode tree){
		if(tree == null)
			return 0;
		return (1 + countNodes(tree.getLeft()) + countNodes(tree.getRight()));
	}

	//Recursive method to check if the tree is complete
	private boolean isComplete(TreeNode tree, int i){
		if(tree == null)
			return true;
		if(i >= count)
			return false;

		return isComplete(tree.getLeft(), (2*i)+1) 
					&& isComplete(tree.getRight(), (2*i)+2);

	}

	//Check for the heap property
	private boolean isHeap(TreeNode tree){

		//Geek Solution
		/*if(tree.getLeft() == null && tree.getRight() == null)
			return true;

		if(tree.getRight() == null)
			return (tree.getLeft().getData() >= tree.getData());
		else{
			if(tree.getData() <= tree.getLeft().getData() 
				&& tree.getData() <= tree.getRight().getData())
				return isHeap(tree.getLeft()) && isHeap(tree.getRight());
			else
				return false;
		}*/ 

		//My Logic
		if(tree == null)
			return true;

		if(tree.getLeft() != null && tree.getLeft().getData() < tree.getData())
			return false;
		if(tree.getRight() != null && tree.getRight().getData() < tree.getData())
			return false;

		return isHeap(tree.getLeft()) && isHeap(tree.getRight());

	}


}