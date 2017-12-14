public class Main{
	public static void main(String[] args) {
		ListNode head = new ListNode(1, null, null);
		head.setNext(new ListNode(31, null, head));
		head.getNext().setNext(new ListNode(3, null, head.getNext()));
	    head.getNext().getNext().setNext(new ListNode(90, null, head.getNext().getNext()));
	    head.getNext().getNext().getNext().setNext(new ListNode(12, null, head.getNext().getNext().getNext()));
	    head.getNext().getNext().getNext().getNext().setNext(new ListNode(8, null, head.getNext().getNext().getNext().getNext()));
	    head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(9, null, head.getNext().getNext().getNext().getNext().getNext()));

	    Reverse rev = new Reverse();
	    print(rev.reverse(head));


	}


	public static void print(ListNode head){
		while(head != null){
			System.out.print(head.getData()+" ");
			head = head.getNext();
		}
	}
}