//https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/
public class QueueArr{
	private int front;
	private int rear;
	private int capacity;
	private int size;
	private int[] qarr;

	public QueueArr(int capacity){
		this.capacity = capacity;
		front = size = 0;
		rear = capacity - 1;
		qarr = new int[capacity];
	}


	public void enqueue(int item){
		if(size == capacity){
			System.out.println("Queue is full");
			return;
		}
		rear = (rear + 1) % capacity;
		size++;
		qarr[rear] = item;
		System.out.println(item + "is added to the queue");
	}

	public void dequeue(){
		if(size == 0){
			System.out.println("Queue is empty");
			return;
		}
		int item = qarr[front];
		front = (front + 1) % capacity;
		size--;
		System.out.println(item + "is removed from the queue");
	}

	public void printQueue(){
		for(int i=rear; i>= front; i--){
			System.out.print(qarr[i]+" ");
		}
		System.out.println();
	}
}