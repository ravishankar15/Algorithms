public class TreeConvertion{

	//https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
	//Note: Idea is to do inorder traversal and keep tract of previous node
	private TreeNode head;
	private TreeNode prev;
	public TreeNode binaryTreeToDLL(TreeNode tree){

		if(tree == null)
			return tree;

		binaryTreeToDLL(tree.getLeft());

		if(head == null)
			head = tree;
		else{
			prev.setRight(tree);
			tree.setLeft(prev);
		}
		prev = tree;

		binaryTreeToDLL(tree.getRight());

		return head;

	}
}