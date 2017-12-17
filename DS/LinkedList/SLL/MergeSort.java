public class MergeSort{
	
	//http://www.geeksforgeeks.org/merge-sort-for-linked-list/
	public ListNode sort(ListNode head){
		if(head == null || head.getNext() == null)
			return head;

		ListNode mid = getMiddle(head);
		ListNode nextOfMid = mid.getNext();
		mid.setNext(null);
		ListNode left = sort(head);
		ListNode right = sort(nextOfMid);

		ListNode sortedHead = sortedMerge(left, right);
		return sortedHead;
	}

	public ListNode sortedMerge(ListNode a, ListNode b){
		ListNode result = null;
		if(a == null)
			return b;
		if(b == null)
			return a;

		if(a.getData() < b.getData()){
			result = a;
			result.setNext(sortedMerge(a.getNext(), b));
		} else {
			result = b;
			result.setNext(sortedMerge(a, b.getNext()));
		}

		return result;
	}


	public ListNode getMiddle(ListNode start){

		if(start == null)
			return start;

		ListNode sp = start;
		ListNode fp = start.getNext();

		while(fp != null){
			fp = fp.getNext();
			if(fp != null){
				sp = sp.getNext();
				fp = fp.getNext();
			}
		}

		return sp;
	}
}