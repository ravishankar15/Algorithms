import java.util.*;
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

	//http://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
	//Note: This is a method that extends the level order traversal
	public TreeNode connectLevelOrder(TreeNode tree){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(tree);
		//Null to point the end of the current level
		q.add(null);
		while(!q.isEmpty()){
			TreeNode temp = q.poll();
			if(temp != null){

				//Next element in the queue represent the next node in the current level
				temp.setNext(q.peek());

				//Populate the queue
				if(temp.getLeft() != null)
					q.add(temp.getLeft());
				if(temp.getRight() != null)
					q.add(temp.getRight());


			} else if(!q.isEmpty()){
				//If the current level is done add null to mark it
				q.add(null);
			}

		}

		return tree;
	}

	//http://www.geeksforgeeks.org/?p=8631
	//Note: This works only for complete binary trees
	public TreeNode connectLevelExtendPre(TreeNode tree){

		if(tree == null)
			return tree;

		//Since its complete binary tree 

		//The next of left child would be right of the root
		if(tree.getLeft() != null)
			tree.getLeft().setNext(tree.getRight());

		//The next of right child would be either the left of the root's next or null
		if(tree.getRight() != null)
			tree.getRight().setNext((tree.getNext() != null ? tree.getNext().getLeft(): null));

		connectLevelExtendPre(tree.getLeft());
		connectLevelExtendPre(tree.getRight());

		return tree;
	}

	//http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
	//Note: This recursive method works for all kinds of trees
	public TreeNode connectLevelOptiRecur(TreeNode tree){

		if(tree == null)
			return tree;

		//Before setting the next right of left and right child 
		//set the next right for the nodes at this level
		if(tree.getNext() != null)
			connectLevelOptiRecur(tree.getNext());

		if(tree.getLeft() != null){
			if(tree.getRight() != null){
				tree.getLeft().setNext(tree.getRight());
				tree.getRight().setNext(getNextRight(tree.getNext()));
			} else {
				tree.getLeft().setNext(getNextRight(tree.getNext()));
			}
			//Recursively call for the next level nodes.
			//Note: we are calling for the left child. The left child will call for
			//the right child
			connectLevelOptiRecur(tree.getLeft());
		} else if(tree.getRight() != null){
			tree.getRight().setNext(getNextRight(tree.getNext()));
			connectLevelOptiRecur(tree.getRight());
		} else {
			connectLevelOptiRecur(tree.getNext());
		}

		return tree;
	}

	//http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
	//Note: This is the optimized solution for connecting the nodes at same level
	public TreeNode connectLevelOpti(TreeNode tree){
		TreeNode p = tree;

		if(p == null)
			return tree;

		//Set next right of root to null
		p.setNext(null);

		//Set next right of all levels one by one
		while(p != null){	
			TreeNode q = p;

			//Connect all children nodes of p and all other nodes at the same level as p
			while(q != null){
				if(q.getLeft() != null){
					if(q.getRight() != null)
						q.getLeft().setNext(q.getRight());
					else 
						q.getLeft().setNext(getNextRight(q.getNext()));
				} if(q.getRight() != null){
					q.getRight().setNext(getNextRight(q.getNext()));
				}
				//Set next right of other nodes in pre order fashion
				q = q.getNext();
			}

			//Start from first node of next level
			if(p.getLeft() != null)
				p = p.getLeft();
			else if(p.getRight() != null)
				p = p.getRight();
			else
				p = getNextRight(p.getNext());
		}
		return tree;
	}

	//Utility Method for finding the next right
	public TreeNode getNextRight(TreeNode t){
		while(t != null){
			if(t.getLeft() != null)
				return t.getLeft();
			if(t.getRight() != null)
				return t.getRight();
			t = t.getNext();
		}
		return null;
	}
}