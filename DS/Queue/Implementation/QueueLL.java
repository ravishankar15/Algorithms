//https://www.geeksforgeeks.org/queue-set-2-linked-list-implementation/
public class QueueLL{

	private QueueNode front;
	private QueueNode rear;

	public QueueLL(){
		front = rear = null;
	}

	public void enqueue(int item){
		
		QueueNode temp = new QueueNode(item);

		if(rear == null){
			System.out.println(item + "is added to queue");
			front = rear = temp;
			return;
		}

		rear.next = temp;
		rear = temp;
		System.out.println(item + "is added to queue");
	}

	public void dequeue(){
		if(front == null) {
			System.out.println("Queue is empty");
			return;
		}

		System.out.println(front.value + "is removed from queue");
		front = front.next;
		if(front == null)
			rear = null;

	}

}
class QueueNode{
	int value;
	QueueNode next;

	public QueueNode(int value){
		this.value = value;
		this.next = null;
	}
}