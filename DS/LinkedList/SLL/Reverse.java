public class Reverse{
	private ListNode head;
	//Iterative Reversing a Linked List
	public ListNode reverseList(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = curr.getNext();

		while(curr != null){
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}

		return prev;
	}

	//Recursively Reversing a Linked List
	public ListNode reverseListRecursive(ListNode curr, ListNode prev){

		if(curr.getNext() == null){
			head = curr;
			curr.setNext(prev);
			return null;
		}
	
		ListNode next = curr.getNext();
		curr.setNext(prev);
		reverseListRecursive(next, curr);
		return head;
	}


	//Only printing the Linked List in Reverse order without actually reversing a link
	public void printReverseList(ListNode head){

		if(head.getNext() != null)
			printReverseList(head.getNext());
		System.out.print(head.getData()+" ");
	}


	// Reverses the linked list between start and end points
	public ListNode reverseBetween(ListNode head, int start, int end){
		ListNode prev = new ListNode(0, null);
		prev.setNext(head);

		for(int i=0; i<start-1; i++)
			prev = prev.getNext();

		final ListNode reversePrev = prev;
		prev = prev.getNext();
		ListNode curr = prev.getNext();

		for(int i=start; i<end; i++){
			prev.setNext(curr.getNext());
			curr.setNext(reversePrev.getNext());
			reversePrev.setNext(curr);
			curr = prev.getNext();
		}

		return head;

	}

	//http://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
	//Note: The base conditions are important in this problem
	public ListNode swapKthNode(ListNode head, int k){

		//Count the number of nodes
		int n = getSize(head);

		//Check if k is valid
		if(n<k)
			return head;

		// If x (kth node from start) and y(kth node from end)
        // are same
		if(2*k - 1== n)
			return head;

		// Find the kth node from beginning of linked list.
        // We also find previous of kth node because we need
        // to update next pointer of the previous.
		ListNode x = head;
		ListNode xPrev = null;
		for(int i=1; i<k; i++){
			xPrev = x;
			x = x.getNext();
		}

		// Similarly, find the kth node from end and its 
        // previous. kth node from end is (n-k+1)th node
        // from beginning
		ListNode y = head;
		ListNode yPrev = null;
		for(int i=1; i<n-k+1; i++){
			yPrev = y;
			y = y.getNext();
		}

		if(xPrev != null)
			xPrev.setNext(y);
		if(yPrev != null)
			yPrev.setNext(x);


		ListNode temp = x.getNext();
		x.setNext(y.getNext());
		y.setNext(temp);


		// Change head pointers when k is 1 or n
		if(k == 1)
			head = y;

		if(k==n)
			head = x;

		return head;

	}


	//Pairwise swapping the elements
	public ListNode swapPairWise(ListNode head){
		ListNode prev = head;
		ListNode curr = head.getNext();

		head = curr;

		while(true){
			ListNode next = curr.getNext();
			curr.setNext(prev);

			if(next == null || next.getNext() == null){
				prev.setNext(next);
				break;
			}

			prev.setNext(next.getNext());
			prev = next;
			curr = prev.getNext();
		}

		return head;
	}

	// Pairwise swapping the values alone
	public ListNode swapPairWiseValues(ListNode head){
		ListNode curr = head;

		while(curr != null && curr.getNext() != null){
			int k = curr.getData();
			curr.setData(curr.getNext().getData());
			curr.getNext().setData(k);
			curr = curr.getNext().getNext();
		}

		return head;
	}


	//http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
	public ListNode reverseInGroups(ListNode head, int k){
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;

		int count = 0;
		/* Reverse first k nodes of linked list */
		while(count < k && curr != null){
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			count++;
		}

		/* next is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.*/
		if(next != null){
			head.setNext(reverseInGroups(next, k));
		}

		//prev is now head of input list
		return prev;
	}

	//Utility Method
	public int getSize(ListNode head){
		int count = 0;
		while(head != null){
			head = head.getNext();
			count++;
		}
		return count;
	}
}