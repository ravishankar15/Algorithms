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
}