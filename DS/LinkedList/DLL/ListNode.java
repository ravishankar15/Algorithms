public class ListNode{
	private int data;
	private ListNode next;
	private ListNode previous; 

	public ListNode(int data, ListNode next, ListNode previous){
		this.data = data;
		this.next = next;
		this.previous = previous;
	}

	public void setData(int data){
		this.data = data;
	}

	public int getData(){
		return this.data;
	}

	public void setNext(ListNode next){
		this.next = next;
	}

	public ListNode getNext(){
		return this.next;
	}

	public void setPrevious(ListNode previous){
		this.previous = previous;
	}

	public ListNode getPrevious(){
		return this.previous;
	}
}