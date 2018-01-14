import java.util.*;
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

		//Using the index construct the left and right subtree
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

	//https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
	public TreeNode buildCompleteFrmSLL(ListNode head){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		//The first node is the root of the tree
		TreeNode tree = new TreeNode(head.getData(), null, null);
		q.add(tree);
		head = head.getNext();
		//Traverse through the linked list
		while(head != null){
			TreeNode parent = q.poll();

			//The next node in the linked list is the left
			//Add that to queue
			parent.setLeft(new TreeNode(head.getData(), null, null));
			q.add(parent.getLeft());
			head = head.getNext();

			//The next node would be right
			if(head != null){
				parent.setRight(new TreeNode(head.getData(), null, null));
				q.add(parent.getRight());
				head = head.getNext();
			}

		}

		return tree;

	}


	//https://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
	private TreeNode root;
	public TreeNode constructFrmParArr(int parent[]){
		int len = parent.length;
		TreeNode[] created = new TreeNode[len];
		for(int i=0; i<len; i++)
			created[i] = null;

		for(int i=0; i<len; i++)
			createTree(parent, i, created);

		return root;
	}
	private void createTree(int parent[], int i, TreeNode created[]){

		//If the node is already created
		if(created[i] != null)
			return;

		//Create the node for the current value
		created[i] = new TreeNode(i, null, null);

		//Check if its parent is the root
		if(parent[i] == -1){
			root = created[i];
			return;
		}

		//Check if the parent is created for the current i
		if(created[parent[i]] == null)
			createTree(parent, parent[i], created);


		TreeNode p = created[parent[i]];

		//Once parent is created attach the child nodes to it
		if(p.getLeft() == null)
			p.setLeft(created[i]);
		else 
			p.setRight(created[i]);


	}
	
}