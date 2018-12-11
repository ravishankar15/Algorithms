public class QueueLL {

	private QueueNode front;
	private QueueNode rear;

	public QueueLL(){
		front = rear = null;
	}

	public void enqueue(Vertex vertex){
		QueueNode temp = new QueueNode(vertex);
		if (rear == null) {
			front = rear = temp;
			return;
		}

		rear.next = temp;
		rear = temp;
	}

	public Vertex dequeue(){
		if (front == null){
			System.out.println("Queue is empty");
			return null;
		}
		Vertex retVal = front.vertex;
		front = front.next;
		if (front == null){
			rear = null;
		}
		return retVal;
	}

	public boolean isEmpty(){
		return front == null ? true : false;
	}
	
}

class QueueNode {
	Vertex vertex;
	QueueNode next;

	public QueueNode(Vertex vertex){
		this.vertex = vertex;
	}
}