public class TreeCalculation{

	//http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
	public int getHeight(TreeNode tree){
		if(tree == null)
			return 0;
		else {
			//Calculate the height of left and right subtree recursively
			int left = getHeight(tree.getLeft());
			int right = getHeight(tree.getRight());

			//Return the max from them
			return left>right ? left+1 : right+1;
		}
	}

	//http://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
	public int getSize(TreeNode tree){
		if(tree == null)
			return 0;
		else 
			//size of a tree = size of left subtree + 1 + size of rightsubtree
			return getSize(tree.getLeft()) + 1 + getSize(tree.getRight());
	}

	//http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
	public boolean rootToLeafSum(TreeNode tree, int sum){
		if(tree == null)
			return (sum == 0);

		else {
			boolean res = false;

			//Subract the sum from the nodes data
			int subsum = sum - tree.getData();

			//If the subsum reaches 0 return true
			if(subsum == 0 && tree.getLeft() == null && tree.getRight() == null)
				return true;
			//The or condition is checked because we need to store the true value if found
			//Because the recursive function runs through all the paths from root to leaf
			if(tree.getLeft() != null){
				res = res || rootToLeafSum(tree.getLeft(), subsum);
			}
			if(tree.getRight() != null){
				res = res || rootToLeafSum(tree.getRight(), subsum);
			}

			return res;
		}
	}

	//http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
	//This: O(n^2)
	// Note: This solution is not optimal Refer the link or below for optimal
	public boolean isBalanced(TreeNode tree){
		if(tree == null)
			return true;

		//Calculate the height of left and right subtree
		int lh = getHeight(tree.getLeft());
		int rh = getHeight(tree.getRight());


		if(Math.abs(lh-rh) <= 1 && isBalanced(tree.getLeft()) && isBalanced(tree.getRight()))
			return true;

		//If we reach here the tree is not balanced
		return false;
	}

	//http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
	//Note: This is an optimized solution with TC: O(n)
	public boolean isBalancedOptimized(TreeNode tree, Height height){

		if(tree == null){
			height.height = 0;
			return true;
		}

		//Create new height object for each roots left and right
		//So that we can track the heights instead of calculating it again
		Height lheight = new Height(); Height rheight = new Height();
		boolean lb = isBalancedOptimized(tree.getLeft(), lheight);
		boolean rb = isBalancedOptimized(tree.getRight(), rheight);

		//Using the height of left and right calculate the height of its root
		int lh = lheight.height; int rh = rheight.height;
		height.height = 1 + (lh > rh ? lh : rh);


		//If the height is not balanced return false
		//Else return true if both its left and right subtree are balanced
		if(Math.abs(lh-rh) >= 2)
			return false;
		else 
			return lb && rb;

	}


	//http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
	// Note: This solution is not optimal Refer the link for optimal
	public int getDiameter(TreeNode tree){
		if(tree == null)
			return 0;

		//Get the height of left and right tree
		int lh = getHeight(tree.getLeft());
		int rh = getHeight(tree.getRight());

		//The diameter can be maximum for nodes 
		//that does not go throught root
		int ld = getDiameter(tree.getLeft());
		int rd = getDiameter(tree.getRight());

		//return the diameter
		return Math.max(lh +  rh + 1, Math.max(ld, rd));
	}

	//http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
	public void rootToLeafPath(TreeNode tree, int[] path, int len){
		if(tree == null)
			return;

		else {
			//Adds the node data on the particular position
			//First the left node is added and once it is printed the 
			//corresponding right node is overridden on the same place
			path[len] = tree.getData();
			len++;
			
			//If the leaf node is reached print the path
			if(tree.getLeft() == null && tree.getRight() == null){
				for(int i=0; i<len; i++)
					System.out.print(path[i]+" ");
				System.out.println();
			} else {
				//Recursively call both subtrees
				rootToLeafPath(tree.getLeft(), path, len);
				rootToLeafPath(tree.getRight(), path, len);
			}
		}
	}
}