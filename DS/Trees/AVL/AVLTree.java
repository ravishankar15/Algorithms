public class AVLTree{

	public TreeNode root;

	public TreeNode insert(TreeNode node, int key){
		
		if(node == null)
			return (new TreeNode(key, null, null));

		if(key < node.getData())
			node.setLeft(insert(node.getLeft(), key));
		else if(key > node.getData())
			node.setRight(insert(node.getRight(), key));
		else 
			return node;

		node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);

		int balance = getBalance(node);


		if(balance > 1 && key < node.getLeft().getData())
			return rightRotate(node);
		if(balance < -1 && key > node.getRight().getData())
			return leftRotate(node);
		if(balance > 1 && key > node.getLeft().getData()){
			node.setLeft(leftRotate(node.getLeft()));
			return rightRotate(node);
		}
		if(balance < -1 && key < node.getRight().getData()){
			node.setRight(rightRotate(node.getRight()));
			return leftRotate(node);
		}

		return node;

	}


	public TreeNode delete(TreeNode root, int key){

		if(root == null)
			return root;

		if(key < root.getData())
			root.setLeft(delete(root.getLeft(), key));
		else if(key > root.getData())
			root.setRight(delete(root.getRight(), key));
		else {

			if(root.getLeft() == null)
				return root.getRight();
			else if(root.getRight() == null)
				return root.getLeft();

			root.setData(getMin(root.getRight()));

			root.setRight(delete(root.getRight(), root.getData()));
		}

		if(root == null)
			return root;



		root.setHeight(Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1);

		int balance = getBalance(root);


		if(balance > 1 && getBalance(root.getLeft()) >= 0)
			return rightRotate(root);
		if(balance > 1 && getBalance(root.getLeft()) < 0){
			root.setLeft(leftRotate(root.getLeft()));
			return rightRotate(root);
		}
		if(balance < -1 && getBalance(root.getRight()) <= 0)
			return leftRotate(root);
		if(balance < -1 && getBalance(root.getRight()) > 0){
			root.setRight(rightRotate(root.getRight()));
			return leftRotate(root);
		}

		return root;
	}


	private int getMin(TreeNode node){
		int min = node.getData();
		while(node.getLeft() != null){
			min = node.getLeft().getData();
			node = node.getLeft();
		}
		return min;
	}

	private TreeNode rightRotate(TreeNode y){
		TreeNode x = y.getLeft();
		TreeNode T2 = x.getRight();

		x.setRight(y);
		y.setLeft(T2);

		y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);
		x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);


		return x;
	}


	private TreeNode leftRotate(TreeNode y){
		TreeNode x = y.getRight();
		TreeNode T2 = x.getLeft();


		x.setLeft(y);
		y.setRight(T2);

		y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);
		x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);


		return x;
	}


	private int getBalance(TreeNode node){
		if(node == null)
			return 0;
		return (getHeight(node.getLeft()) - getHeight(node.getRight()));
	}


	private int getHeight(TreeNode node){
		if(node == null)
			return 0;
		return node.getHeight();
	}
}