import java.util.*;
public class TreeView{
	
	//https://www.geeksforgeeks.org/print-left-view-binary-tree/
	//Note: https://www.geeksforgeeks.org/deepest-left-leaf-node-in-a-binary-tree/
	//Refer similar kind of problem in the Note Link
	private int max_level = 0;
	public void printLeftView(TreeNode tree, int level){

		if(tree == null)
			return;

		if(max_level < level){
			System.out.print(tree.getData()+" ");
			max_level = level;
		}

		printLeftView(tree.getLeft(), level + 1);
		printLeftView(tree.getRight(), level + 1);

	}

	//https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
	//Note: Use the common private max_level variable declared above
	public void printRightView(TreeNode tree, int level){

		if(tree == null)
			return;

		if(max_level < level){
			System.out.print(tree.getData()+" ");
			max_level = level;
		}

		printRightView(tree.getRight(), level + 1);
		printRightView(tree.getLeft(), level + 1);

	}

	//https://www.geeksforgeeks.org/bottom-view-binary-tree/
	public HashMap<Integer, Integer> printBottomView(TreeNode tree){
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int hd = 0;

		//The horizontel distance of the root is 0
		tree.setHd(hd);
		q.add(tree);

		while(!q.isEmpty()){

			TreeNode temp = q.remove();

			// Extract the horizontal distance value from the
            // dequeued tree node.

			hd = temp.getHd();

			// Put the dequeued tree node to TreeMap having key
            // as horizontal distance. Every time we find a node
            // having same horizontal distance we need to replace
            // the data in the map.
			hm.put(hd, temp.getData());

			// If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd-1.
			if(temp.getLeft() != null){
				temp.getLeft().setHd(hd-1);
				q.add(temp.getLeft());
			}
			// If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd+1.
			if(temp.getRight() != null){
				temp.getRight().setHd(hd+1);
				q.add(temp.getRight());
			}

		}
		return hm;
	}

	//https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
	//Note: Very similar to bottom view
	public HashMap<Integer, Integer> printTopView(TreeNode tree){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int hd = 0;

		//The horizontel distance of the root is 0
		tree.setHd(hd);
		q.add(tree);

		while(!q.isEmpty()){

			TreeNode temp = q.remove();
			hd = temp.getHd();

			//We need to consider only the first occurence
			//in the vertical line
			if(!hm.containsKey(hd)){
				hm.put(hd, temp.getData());
			}

			// If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd-1.
			if(temp.getLeft() != null){
				temp.getLeft().setHd(hd-1);
				q.add(temp.getLeft());
			}
			// If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd+1.
			if(temp.getRight() != null){
				temp.getRight().setHd(hd+1);
				q.add(temp.getRight());
			}

		}
		return hm;

	}
}