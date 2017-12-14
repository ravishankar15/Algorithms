public class FindAnElement{


	//Iteratively Finding a Element
	public static boolean findElement(ListNode head, int element){

		ListNode curr = head;

		while(curr != null){
			if(curr.getData() == element)
				return true;
			curr = curr.getNext();
		}

		return false;
	}

	//Recursively Finding an Element
	public static boolean findElementRecursive(ListNode head, int element){
		if(head == null)
			return false;
		else if(head.getData() == element)
			return true;

		return findElementRecursive(head.getNext(), element);
	}

}