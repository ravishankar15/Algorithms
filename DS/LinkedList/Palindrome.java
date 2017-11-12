public class Palindrome{

	//http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
	private ListNode left = new ListNode(0, null);
	public boolean isPalindrome(ListNode right, ListNode head){
		
		//This is to keep the left as head till the right pointer reaches the end
		//It is declared global so that the change is reflected in all recursive calls
		left = head;

		//Stop recursion if the right becomes null
		if(right == null)
			return true;

		boolean isp = isPalindrome(right.getNext(), head);
		//If the sublist is not a palindrome than no need to check the rest
		//We can directly return false
		if(!isp)
			return false;

		//Check the values of left and right
		boolean isp1 = left.getData() == right.getData();
		//Move the left to next node
		left = left.getNext();

		return isp1;
	}
}