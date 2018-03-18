//https://www.geeksforgeeks.org/circular-queue-set-2-circular-linked-list-implementation/
public class CircularQueueLL{

	private ListNode front;
	private ListNode rear;

	public void enqueue(int data){
		ListNode temp = new ListNode(data);

		if(rear == null){
			front = rear = temp;
		} else {
			rear.next = temp;
			rear = temp;
		}
		rear.next = front;

		System.out.println(data + "is added to the Queue");
	}

	public void dequeue(){
		if(front == null){
			System.out.println("Queue is empty");
			return;
		}
		int value = front.data;
		if(front == rear){
			front = rear = null;
		} else {
			front = front.next;
			rear.next = front;
		}

		System.out.println(value +" is removed from the Queue");
	}

}

class ListNode{
	int data;
	ListNode next;

	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
}