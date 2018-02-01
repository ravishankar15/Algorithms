//https://www.geeksforgeeks.org/quicksort-on-singly-linked-list/
//Note: https://ide.geeksforgeeks.org/vjz17K
public class QuickSort{

	public ListNode sort(ListNode start, ListNode end){

		if(start == null || start == end)
			return start;

		Holder h = new Holder();
		ListNode pivot = partition(start, end, h);
		//If we dont have the left list than we dont need to recur to left
		if(h.headstart != pivot){
			
			ListNode temp = h.headstart;

			while(temp.getNext() != pivot)
				temp = temp.getNext();
			temp.setNext(null);

			h.headstart = sort(h.headstart, temp);

			temp = getLastNode(h.headstart);
			temp.setNext(pivot);
		} 
		//Recur for the right side of the list
		pivot.setNext(sort(pivot.getNext(), h.headend));

		return h.headstart;
	}


	private ListNode partition(ListNode start, ListNode end, Holder h){

		// the plan is start from the head
		// if you find something bigger than
		// the pivot, place it behind the last node

		ListNode pivot = end;
		ListNode current = start;
		ListNode prev = null;
		ListNode tail = end;

		while(current != end){
			if(current.getData() < pivot.getData()){
				// the first item less than pivot becomes the head
				if(h.headstart == null)
					h.headstart = current;
				prev = current;
				current = current.getNext();
			} else {
				// cut the link and move it to the end
				if(prev != null)
					prev.setNext(current.getNext());

				ListNode temp = current.getNext();
				current.setNext(null);
				tail.setNext(current);
				tail = current;
				current = temp;		
			}
		}
		// let us assume that pivot is smallest of all
		// so the headStart is still null
		if (h.headstart == null) {
			h.headstart = pivot;
		}
		// now we save the end
		h.headend = tail;
		// this is returned because everything greater to it is on right
		// and everything less to the left
		return pivot;


	}

	private ListNode getLastNode(ListNode head){
		while(head.getNext() != null)
			head = head.getNext();
		return head;
	}

}
class Holder{
	ListNode headstart;
	ListNode headend;
}
