//https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
public class CircularQueueArr{
	private int front;
	private int rear;
	private int size;
	private int[] cqarr;

	public CircularQueueArr(int size){
		this.size = size;
		front = rear = -1;
		cqarr = new int[size];
	}


	public void enqueue(int item){
		if((front == 0 && rear == size-1)||(rear == front - 1)){
			System.out.println("Queue is full");
			return;
		} else if(front == -1){
			front = rear = 0;
			cqarr[rear] = item;
		} else if((rear == size - 1) && front != 0){
			rear = 0;
			cqarr[rear] = item;
		} else{
			cqarr[++rear] = item;
		}
		System.out.println(item + " is added to the queue");
	}

	public void dequeue(){

		if(front == -1){
			System.out.println("Queue is empty");
			return;
		}

		int data = cqarr[front];
		cqarr[front] = -1;
		if(front == rear){
			front = rear = -1;
		} else if(front == size-1){
			front = 0;
		} else {
			front++;
		}
		System.out.println(data + "is removed from the queue");
	}
}