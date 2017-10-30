public class TreeCalculation{

	//http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
	 public boolean isBST(TreeNode tree, int min, int max){

	 	//If the tree reaches the end or tree is empty return true
	 	if(tree == null)
	 		return true;

	 	//If the tree violates the min and max condition
	 	if(tree.getData() < min || tree.getData() > max)
	 		return false;

	 	//Check the left and right subtree recursively narrowing the min and max values
	 	return isBST(tree.getLeft(), min, tree.getData()-1) && isBST(tree.getRight(), tree.getData()-1, max);

	 }


	 //http://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/
	 //Note: If all internal nodes in BST have only one child than all the nodes next to it should 
	 //either be smaller or greater than the current
	 public boolean hasOnlyOneChild(int[] pre){
	 	int nextDiff, lastDiff;
	 	int size = pre.length;
	 	for(int i=0; i<size-1; i++){
	 		nextDiff = pre[i] - pre[i+1];
	 		lastDiff = pre[i] - pre[size-1];
	 		//If pre[i+1] or pre[size-1] is smaller than -*- = +
	 		//If pre[i+1] or pre[size-1] is greater than +*+ = +
	 		//For all other conditon the below will become negative
	 		if(nextDiff*lastDiff < 0)
	 			return false;
	 	}
	 	return true;
	 }
}