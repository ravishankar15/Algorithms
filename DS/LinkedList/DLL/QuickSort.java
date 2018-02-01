//https://www.geeksforgeeks.org/quicksort-for-linked-list/
public class QuickSort{
	public ListNode sort(ListNode head, ListNode start, ListNode end){

		//This if condition is important 
		if(end != null && start != end && start != end.getNext()){

			ListNode temp = partition(start, end);
			sort(head, start, temp.getPrevious());
			sort(head, temp.getNext(), end);

		}

		return head;
	}


	private ListNode partition(ListNode start, ListNode end){

		int x = end.getData();

		ListNode i = start.getPrevious();

		for(ListNode j = start; j!=end; j = j.getNext()){
			if(j.getData() < x){
				i = (i == null) ? start : i.getNext(); //Similar to i++
				int t = j.getData();
				j.setData(i.getData());
				i.setData(t);
			}
		}

		i = (i == null) ? start : i.getNext(); //Similar to i++
		int t = i.getData();
		i.setData(x);
		end.setData(t);

		return i;

	}
}