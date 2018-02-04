public class TreeNode{
	private int data;
	private int height;
	private TreeNode left;
	private TreeNode right;
	private int count; //For handling duplicates

	public TreeNode(int data, TreeNode left, TreeNode right){
		this.data = data;
		this.left = left;
		this.right = right;
		height = 1;
	}


	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}



}