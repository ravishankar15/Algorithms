public class Merge{

	// Merging two sorted list
	public ListNode mergeSortedList(ListNode head1, ListNode head2){


		ListNode head = new ListNode(0, null);
		ListNode trav = head;

		while(head1 != null && head2 != null){
			if(head1.getData() < head2.getData()){
				trav.setNext(head1);
				head1 = head1.getNext();
				trav = trav.getNext();
			} else {
				trav.setNext(head2);
				head2 = head2.getNext();
				trav = trav.getNext();
			}
		}

		while(head1 != null){
			trav.setNext(head1);
			head1 = head1.getNext();
			trav = trav.getNext();
		}

		while(head2 != null){
			trav.setNext(head2);
			head2 = head2.getNext();
			trav = trav.getNext();
		}

		return head.getNext();

	}
}