public class TreeConnection{
	
	//http://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/
	//Note: Traverse the tree in reverse inorder and keep track of previous node
	public void populateInorderSucc(TreeNode tree, TreeNode nextRef){

		// The first visited node will be the rightmost node
        // next of the rightmost node will be NULL
		if(tree == null)
			return;

		populateInorderSucc(tree.getRight(), nextRef);

		// Set the next as previously visited node in reverse Inorder
		tree.setNext(nextRef);

		// Change the prev for subsequent node
		nextRef = tree;

		System.out.print(nextRef.getData()+" ");

		populateInorderSucc(tree.getLeft(), nextRef);
	}
}