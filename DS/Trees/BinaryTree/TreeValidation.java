import java.util.*;
public class TreeValidation{

	//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
	public boolean isSumTree(TreeNode tree){

		if(tree == null || isLeaf(tree))
			return true;

		if(isSumTree(tree.getLeft()) && isSumTree(tree.getRight())){
			int ls; int rs;

			/*
				1. If it is a leaf node than the value is the value of that node
				2. If it is not a leaf node than the value is twice the value of the node(Assuming 
					that node rooted tree is a sum tree)
			*/


			if(tree.getLeft() == null)
				ls = 0;
			else if(isLeaf(tree.getLeft()))
				ls = tree.getLeft().getData();
			else
				ls = 2 * tree.getLeft().getData();


			if(tree.getRight() == null)
				rs = 0;
			else if (isLeaf(tree.getRight())) 
				rs = tree.getRight().getData();
			else
				rs = 2 * tree.getRight().getData();

			return (tree.getData() == ls + rs);
		}

		return false;

	}

	//Utility function to check as leaf
	public boolean isLeaf(TreeNode tree){
		if(tree != null && tree.getLeft() == null && tree.getRight() == null){
			return true;
		}
		return false;

	}


	//https://www.geeksforgeeks.org/foldable-binary-trees/
	//Note: For simplification the root is assumed to be foldable
	public boolean isFoldable(TreeNode left, TreeNode right){
		
		//Since the logic is to check only the structure

		//Left and right both should be null
		if(left == null && right == null)
			return true;

		//If one is null and another is not
		if(left == null || right == null)
			return false;


		return (isFoldable(left.getLeft(), right.getRight()) 
				&& isFoldable(left.getRight(), right.getLeft()));

	}

	//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
	public boolean isComplete(TreeNode tree){
		if(tree == null)
			return true;
		boolean flag = false;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(tree);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			if(temp.getLeft() != null){

				if(flag)
					return false;

				queue.add(temp.getLeft());
			} else
				flag = true;

			if(temp.getRight() != null){
			
				if(flag)
					return false;
			
				queue.add(temp.getRight());
			} else 
				flag = true;
		}

		return true;

	}
}