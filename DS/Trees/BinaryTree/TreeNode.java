public class TreeNode{
	private int data;
	private TreeNode left;
	private TreeNode right;

	//Utility for storing any additional nodes
	private TreeNode next;
	private int hd;

	public TreeNode(int data, TreeNode left, TreeNode right, TreeNode next){
		this.data = data;
		this.left = left;
		this.right = right;
		this.next = next;
	}

	public TreeNode(int data, TreeNode left, TreeNode right){
		this.data = data;
		this.left = left;
		this.right = right;
		
		this.hd = Integer.MAX_VALUE;
	}

	public void setHd(int hd){
		this.hd = hd;
	}

	public int getHd(){
		return this.hd;
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


	public TreeNode getNext(){
		return this.next;
	}

	public void setNext(TreeNode next){
		this.next = next;
	}
}