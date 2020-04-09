//http://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
//http://www.geeksforgeeks.org/program-page-replacement-algorithms-set-2-fifo/
import java.util.*;
public class Standard{
	private TreeNode root;
	//Convert the given Linked List representation to Binary tree
	public TreeNode getBinaryTree(ListNode head){
		//Create an empty Queue
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		//Base condition if the list is null return
		if(head == null)
			return null;

		//We know that head is always the root
		root = new TreeNode(head.getData(), null, null);
		q.add(root); //Add the root to the queue

		head = head.getNext();

		//Traverse till the end of the linked list
		while(head != null){
			TreeNode left = null; TreeNode right=null;

			//Create the left child and push it to queue
			left = new TreeNode(head.getData(), null, null);
			q.add(left);
			head = head.getNext(); //Move the head pointer

			//Create right child and push it to queue
			if(head != null){
				right = new TreeNode(head.getData(), null, null);
				q.add(right);
				head = head.getNext();
			}
			//Poll the parent and set the left and right child
			TreeNode parent = q.poll();
			parent.setLeft(left);
			parent.setRight(right);

		}
		return root;
	}

	//Simple implementation of the Page Replacement Algorithm
	public int replaceAlgo(int[] arr, int cap){
		int n = arr.length;

		//Set to store the current pages 
		HashSet<Integer> set = new HashSet<Integer>();

		//To store the pages in FLIFO
		Queue<Integer> queue = new LinkedList<Integer>();

		//To count the page fault
		//Page Fault: If the page is not present in the current set
		int pf = 0;	
		//Traverse all the elements in the array
		for(int i=0; i<n; i++){

			//If we have space to include the new page
			//Check if it is present in the current set
			//if not add it to set and the queue
			if(set.size() < cap){
				if(!set.contains(arr[i])){
					set.add(arr[i]);
					queue.add(arr[i]);
					pf++;
				}
			}
			//If not check if it is present in the current if not
			//Poll the queue: which is the first visited page
			//Remove the poll from the set 
			else {
				if(!set.contains(arr[i])){
					int val = queue.poll();
					set.remove(val);
					set.add(arr[i]);
					queue.add(arr[i]);
					pf++;
				}
			}
		}
		return pf;
	}

	/*To Check if the given tree is a complete binary tree*/
	public boolean isCompleteBT(TreeNode root){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    
    while(!q.isEmpty()) {
        int size = q.size();
        boolean flag = false;
        while(size-- > 0) {
            TreeNode top = q.poll();
            if (top != null) {
                q.add(top.left);
                q.add(top.right); 
            } else {
                flag = true;
                break;
            }
        }
        if (flag) break;
    }
    
    while(!q.isEmpty()) {
        if (q.poll() != null)
            return false;
    }
    return true;
	}
}