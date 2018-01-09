public class Main{
	public static void main(String[] args) {
		MinHeap min = new MinHeap(6);
		min.insert(1);
		min.insert(3);
		min.insert(6);
		min.insert(9);
		min.insert(8);
		min.insert(5);
		min.print();
		min.extractMin();
		min.decreaseKey(3, 1);
		min.print();


		MaxHeap max = new MaxHeap(6);
		max.insert(1);
		max.insert(3);
		max.insert(6);
		max.insert(9);
		max.insert(8);
		max.insert(5);
		max.print();
		max.extractMax();
		max.increaseKey(3, 20);
		max.print();


	}
}