public class Reverse{
	//http://www.geeksforgeeks.org/reverse-a-doubly-linked-list/
	public ListNode reverse(ListNode head){
		ListNode temp = null;
		ListNode curr = head;

		while(curr != null){
			temp = curr.getPrevious();
			curr.setPrevious(curr.getNext());
			curr.setNext(temp);
			curr = curr.getPrevious();
		}

		if(temp != null)
			head = temp.getPrevious();

		return head;

	}
}