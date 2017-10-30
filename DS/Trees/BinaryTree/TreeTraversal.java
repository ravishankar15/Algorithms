import java.util.*;
public class TreeTraversal{

	public void recursiveInOrder(TreeNode tree){
		if(tree == null)
			return;

		recursiveInOrder(tree.getLeft());
		System.out.print(tree.getData()+" ");
		recursiveInOrder(tree.getRight());
	}

	public void recursivePreOrder(TreeNode tree){
		if(tree == null)
			return;
		System.out.print(tree.getData()+" ");
		recursivePreOrder(tree.getLeft());
		recursivePreOrder(tree.getRight());
	}

	public void recursivePostOrder(TreeNode tree){
		if(tree == null)
			return;
		recursivePostOrder(tree.getLeft());
		recursivePostOrder(tree.getRight());
		System.out.print(tree.getData()+" ");
	}

	public void printLevelOrder(TreeNode tree){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(tree);
		while(!queue.isEmpty()){
			int size = queue.size();
			//while loop for printing the level order in next next line
			while(size-- > 0){
				TreeNode temp = queue.poll();
				if(temp.getLeft() != null)
					queue.add(temp.getLeft());
				if(temp.getRight() != null)
					queue.add(temp.getRight());
				System.out.print(temp.getData()+" ");
			}
			System.out.println();
		}
	}

	public void stackInOrder(TreeNode tree){
		Stack<TreeNode> st = new Stack<TreeNode>();
		while(tree != null){
			st.push(tree);
			tree = tree.getLeft();
		}

		while(!st.isEmpty()){
			TreeNode temp = st.pop();
			System.out.print(temp.getData()+" ");
			if(temp.getRight() != null){
				temp = temp.getRight();
				while(temp != null){
					st.push(temp);
					temp = temp.getLeft();
				}
			}
		}
	}

	public void stackPreOrder(TreeNode tree){
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(tree);
		while(!st.isEmpty()){
			TreeNode temp = st.pop();
			System.out.print(temp.getData()+" ");

			if(temp.getRight() != null)
				st.push(temp.getRight());
			if(temp.getLeft() != null)
				st.push(temp.getLeft());
		}

	}


	public void stackPostOrder(TreeNode tree){
		Stack<TreeNode> st1 = new Stack<TreeNode>();
		Stack<TreeNode> st2 = new Stack<TreeNode>();

		st1.push(tree);
		while(!st1.isEmpty()){

			TreeNode temp = st1.pop();
			st2.push(temp);

			if(temp.getLeft() != null)
				st1.push(temp.getLeft());
			if(temp.getRight() != null)
				st1.push(temp.getRight());
		}

		while(!st2.isEmpty())
			System.out.print(st2.pop().getData()+" ");
	}

}