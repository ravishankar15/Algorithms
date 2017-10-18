public class TreeNode{
	private int data;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int data, TreeNode left, TreeNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public void setData(int data){
		this.data = data;
	}

	public int getData(){
		return this.data;
	}

	public void setLeft(TreeNode left){
		this.left = left;
	}

	public TreeNode getLeft(){
		return this.left;
	}

	public void setRight(TreeNode right){
		this.right = right;
	}

	public TreeNode getRight(){
		return this.right;
	}
}