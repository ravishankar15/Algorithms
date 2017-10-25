public class TreeConstruction{

	//http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
	private int preIndex = 0;
	public TreeNode buildTreeFrmInAndPre(int[] in, int[] pre, int instart, int inend){
		//Pick an element from the preOrder
		TreeNode tnode = new TreeNode(pre[preIndex++], null, null);

		//If the node has no child than return the tnode
		//Since preOrder starts with root
		if(instart == inend)
			return tnode;

		//Find the left and right side values from the inorder array
		int index = 0;
		for(int i=instart; i<=inend; i++){
			//If the value is found than the elements to the left falls is left subtree
			//elements to the right falls in right subtree
			if(tnode.getData() == in[i]){
				index = i;
				break;
			}
		}

		//Using the index constrcut the left and right subtree
		tnode.setLeft(buildTreeFrmInAndPre(in, pre, instart, index-1));
		tnode.setRight(buildTreeFrmInAndPre(in, pre, index+1, inend));

		return tnode;
	}

	//http://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals/
	public TreeNode buildTreeFrmInAndLevel(TreeNode snode, int[] in, int[] level, int instart, int inend){

		if(instart == inend)
			return new TreeNode(in[instart], null, null);

		int index = 0;
		boolean flag = false; //To break the loop

		//The loop identifies the index in inorder array that 
		//first appears in the level order
		for(int i=0; i<level.length; i++){
			int data = level[i];
			//we check the level order value in the left subarray for first recursive call
			//and than the right subarray for the second recursive call
			for(int j=instart; j<=inend; j++){
				if(data == in[j]){
					snode = new TreeNode(data, null, null);
					flag = true;
					index = j;
					break;
				}
			}
			if(flag)
				break;
		}

		//Recusively attach the left and right subtrees
		snode.setLeft(buildTreeFrmInAndLevel(snode, in, level, instart, index-1));
		snode.setRight(buildTreeFrmInAndLevel(snode, in, level, index+1, inend));

		return snode;


	}
	
}