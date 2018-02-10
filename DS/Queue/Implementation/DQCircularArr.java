//https://www.geeksforgeeks.org/implementation-deque-using-circular-array/
public class DQCircularArr{
	private int size;
	private int[] cqarr;
	private int front;
	private int rear;

	public DQCircularArr(int size){
		this.size = size;
		front = rear = -1;
		cqarr = new int[size];
	}

	private boolean isFull(){
		return ((front == 0 && rear == size - 1) || (rear == front - 1));
	}

	private boolean isEmpty(){
		return (front == -1);
	}

	public void insertRear(int data){

		if(isFull()){
			System.out.println("Queue is full");
			return;
		} if (front ==  -1){
			front = rear = 0;
		} else if(rear == size - 1){
			rear = 0;
		} else {
			rear++;
		}
		cqarr[rear] = data;
		System.out.println(data + " is inserted into the rear");
	}

	public void insertFront(int data){
		if(isFull()){
			System.out.println("Queue is full");
			return;
		} if(front == -1){
			front = rear = 0;
		} else if(front == 0){
			front = size - 1;
		} else {
			front--;
		}
		cqarr[front] = data;
		System.out.println(data + " is inserted into the front");
	}

	public void deleteRear(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return;
		} 
		int data = cqarr[rear];
		if(front == rear){
			front = rear = -1;
		} else if(rear == 0){
			rear = size - 1;
		} else {
			rear--;
		}
		System.out.println(data + " is deleted from the rear");
	}


	public void deleteFront(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return;
		}
		int data = cqarr[front]; 
		if(front == rear){
			front = rear = -1;
		} else if(front == size - 1){
			front = 0;
		} else {
			front++;
		}
		System.out.println(data + " is deleted from the front");
	}
}