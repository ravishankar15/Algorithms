import java.util.*;
public class TreeConstruction{

	//http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
	public TreeNode buildTreeFromPre(int[] pre, int key, Index preIndex, int min, int max){

		//Base case
		if(preIndex.index >= pre.length)
			return null;

		TreeNode tree = null;

		//If the current element is in range than only it is a part of this subtree
		//Note: The preIndex object is used to keep track of the index in pre order array
		if(key > min && key < max){
			tree = new TreeNode(key, null, null);
			preIndex.index = preIndex.index + 1;
			if(preIndex.index < pre.length){

				//All nodes in range of [min..key] will go to left
				tree.setLeft(buildTreeFromPre(pre, pre[preIndex.index], preIndex, min, key));

				//All nodes in range of [key..max] will go to right
				tree.setRight(buildTreeFromPre(pre, pre[preIndex.index], preIndex, key, max));
			}
		}

		return tree;
	}

	//http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/
	public TreeNode buildTreeFromPreStack(int[] pre){

		//In pre order the first node is the root
		TreeNode tree = new TreeNode(pre[0], null, null);

		//Create a empty stack and push the root node into it
		//The stack should be in increasing order from top
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(tree);

		for(int i=0; i<pre.length; i++){
			TreeNode temp = null;

			//Pop the elements till the top is greater than the current
			while(!st.isEmpty() && pre[i] > st.peek().getData())
				temp = st.pop();

			//Make this greater child as right and push it to stack
			if(temp != null){
				temp.setRight(new TreeNode(pre[i], null, null));
				st.push(temp.getRight());
			} 
			//If the new value is less than the top value 
			//set this value as left of the top value and push that node to stack
			else {
				temp = st.peek();
				temp.setLeft(new TreeNode(pre[i], null, null));
				st.push(temp.getLeft());
			}
		}
		return tree;
	}
}