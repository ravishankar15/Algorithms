public class Main{
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1, null);
		head.setNext(new ListNode(31, null));
		head.getNext().setNext(new ListNode(3, null));
	    head.getNext().getNext().setNext(new ListNode(90, null));
	    head.getNext().getNext().getNext().setNext(new ListNode(12, null));
	    head.getNext().getNext().getNext().getNext().setNext(new ListNode(8, null));
	    head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(9, null));

	    //Uncomment the below line for creating a loop in the linked list
	    /*head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(head.getNext().getNext().getNext());*/

	    ListNode srtHead1 = new ListNode(1, null);
		srtHead1.setNext(new ListNode(3, null));
		srtHead1.getNext().setNext(new ListNode(5, null));
	    srtHead1.getNext().getNext().setNext(new ListNode(7, null));
	    srtHead1.getNext().getNext().getNext().setNext(new ListNode(9, null));
	    srtHead1.getNext().getNext().getNext().getNext().setNext(new ListNode(10, null));
	    srtHead1.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(11, null));


	    ListNode srtHead2 = new ListNode(2, null);
		srtHead2.setNext(new ListNode(4, null));
		srtHead2.getNext().setNext(new ListNode(6, null));
	    srtHead2.getNext().getNext().setNext(new ListNode(8, null));
	    srtHead2.getNext().getNext().getNext().setNext(new ListNode(12, null));
	    srtHead2.getNext().getNext().getNext().getNext().setNext(new ListNode(13, null));
	    srtHead2.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(14, null));


	    ListNode head1 = new ListNode(9, null);
		head1.setNext(new ListNode(9, null));
		head1.getNext().setNext(new ListNode(9, null));
	    head1.getNext().getNext().setNext(new ListNode(9, null));
	    head1.getNext().getNext().getNext().setNext(new ListNode(9, null));


	    ListNode head2 = new ListNode(1, null);
		head2.setNext(new ListNode(2, null));
		head2.getNext().setNext(new ListNode(2, null));
	    head2.getNext().getNext().setNext(new ListNode(1, null));


	    //Searching an element in the Linked List
	    //FindAnElement find = new FindAnElement();
	    //System.out.println(find.findElement(head, 9)); //Iteratively Finding a Element
	    //System.out.println(find.findElementRecursive(head, 31)); //Recursively Finding an Element 

	    //Reversing a Linked List
	    Reverse rev = new Reverse();
	    //print(rev.reverseList(head)); //Iterative Reversing a Linked List
	    //print(rev.reverseListRecursive(head, null)); //Recursively Reversing a Linked List
	    //rev.printReverseList(head); //Only printing the Linked List in Reverse order without actually reversing a link 
	    //print(rev.reverseBetween(head, 2, 4)); // Reverses the linked list between two specified points
	    //print(rev.swapPairWise(head)); // Pairwise swapping the ListNodes
	    //print(rev.swapPairWiseValues(head)); // Pairwise swapping the values alone
	    print(rev.reverseInGroups(head, 3));

	    //Detecting a Loop in Linked List
	    //LoopDetection loop = new LoopDetection();
	    //System.out.println(loop.detectLoop(head)); //Detects Loop using Floyd’s Cycle-Finding Algorithm
	    //System.out.println(loop.getLoopStart(head).getData()); //Detects Loops starting using Floyd’s Cycle-Finding Algorithm
	    //print(loop.detectAndRemoveLoop(head)); //Detect and Remove the loop


	    //Merge merge = new Merge();
	    //print(merge.mergeSortedList(srtHead1, srtHead2)); // Merging two sorted list

	    //ListAddition la = new ListAddition();
	    //print(la.addOneToList(head1));
	    //print(la.addTwoNumAsList(head1, head2));
	    //print(la.addTwoLinkedList(head1, head2));


	   /* Palindrome p = new Palindrome();
	    System.out.println(p.isPalindrome(head2, head2));*/

	}


	public static void print(ListNode head){
		while(head != null){
			System.out.print(head.getData()+" ");
			head = head.getNext();
		}
	}
}