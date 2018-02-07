//Very similar to MinHeap 
//Refer: https://www.geeksforgeeks.org/binary-heap/
public class MaxHeap{

	private int capacity;
	private int heapSize;
	private int[] harr;

	public MaxHeap(int cap){
		capacity = cap;
		heapSize = 0;
		harr = new int[capacity];
	}
	private int parent(int i){
		return (i-1)/2;
	}
	private int left(int i){
		return (2*i) + 1;
	}
	private int right(int i){
		return (2*i) + 2;
	}
	//Swap the value in heap array
	private void swap(int a, int b){
		int temp = harr[a];
		harr[a] = harr[b];
		harr[b] = temp;
	}
	//Prints the heap
	public void print(){
		System.out.println();
		for(int i=0; i<heapSize; i++){
			System.out.print(harr[i]+" ");
		}
	}
	////Returns the max value of the heap
	public int getMax(){
		return harr[0];
	}

	//Inserts the key into the heap
	public void insert(int key){

		if(heapSize == capacity){
			System.out.println("OverFlow: Heap is full");
		}

		//First insert the key at the end of heap
		int i = heapSize;
		heapSize++;
		harr[i] = key;
		//Check max heap property for all its ancestors
		while(i != 0 && harr[i] > harr[parent(i)]){
			swap(parent(i), i);
			i = parent(i);
		}

	}
	//Returns and removes the maximum element from the heap
	public int extractMax(){

		if(heapSize == 0)
			return Integer.MIN_VALUE;
		if(heapSize == 1){
			heapSize--;
			return harr[0];
		}

		//Store the maximum value and remove it from the heap
		int max = harr[0];

		//Put the last value of the heap into the first
		harr[0] = harr[heapSize - 1];
		heapSize--;
		maxHeapify(0);

		return max;
	}
	// A Recursive method to heapify a subtree with root at given index
	// This method assumes that the subtree are already heapified
	public void maxHeapify(int i){
		int l = left(i);
		int r = right(i);
		int largest = i;

		if(l < heapSize && harr[l] > harr[largest])
			largest = l;
		if(r < heapSize && harr[r] > harr[largest])
			largest = r;

		if(largest != i){
			swap(largest, i);
			maxHeapify(largest);
		}
	}
	// This function deletes key at index i. It first increases value to
	// infinite, then calls extractMin()
	public void deleteKey(int i){
		increaseKey(i, Integer.MAX_VALUE);
		extractMax();
	}
	// Increases value at index 'i' to newval.  It is assumed that
	// newval is greater than harr[i].
	public void increaseKey(int i, int newval){
		harr[i] = newval;
		while(i != 0 && harr[i] > harr[parent(i)]){
			swap(i, parent(i));
			i = parent(i);
		}
	}


}