public class Main{
	public static void main(String[] args) {
		/*QueueArr q = new QueueArr(5);
		q.enqueue(10); q.enqueue(20); q.enqueue(30); q.enqueue(40); 
		q.printQueue();
		q.dequeue(); q.dequeue(); 
		q.printQueue();*/

		/*QueueLL qll = new QueueLL();
		qll.enqueue(10); qll.enqueue(20); qll.enqueue(30); qll.enqueue(40);
		qll.dequeue(); qll.dequeue();*/

		/*CircularQueueArr cqa = new CircularQueueArr(5);
		cqa.enqueue(10); cqa.enqueue(20); cqa.enqueue(30); 
		cqa.enqueue(40); cqa.enqueue(50); cqa.enqueue(60); 
		cqa.dequeue(); cqa.dequeue(); */

		/*DQCircularArr dq = new DQCircularArr(5);
		dq.insertRear(5); dq.insertRear(10); dq.insertFront(15);
		dq.deleteRear(); dq.insertFront(15); dq.deleteFront();*/

		CircularQueueLL cql = new CircularQueueLL();
		cql.enqueue(10); cql.enqueue(20);
		cql.dequeue(); cql.dequeue();cql.dequeue();
	}
}