//https://www.geeksforgeeks.org/binary-heap/
public class MinHeap{
	
	private int[] harr;
	private int capacity;
	private int heapSize;

	public MinHeap(int cap){
		heapSize = 0;
		capacity = cap;
		harr = new int[capacity];
	}

	//Prints the heap
	public void print(){
		System.out.println();
		for(int i=0; i<heapSize; i++){
			System.out.print(harr[i]+" ");
		}
	}

	//Swap the value in heap array
	public void swap(int a, int b){
		int temp = harr[a];
		harr[a] = harr[b];
		harr[b] = temp;
	}

	//Returns the parent of i
	public int parent(int i){
		return (i-1)/2;
	}

	//Returns the left child of i
	public int left(int i){
		return (2*i) + 1;
	}

	//Returns the right child of i
	public int right(int i){
		return (2*i) + 2;
	}

	//Returns the min value of the heap
	public int getMin(){
		return harr[0];
	}

	//Inserts the key into the heap
	public void insert(int key){

		if(heapSize == capacity){
			System.out.println("Overflow: Heap is full");
		}

		//First insert the key at the end of heap
		int i = heapSize;
		heapSize++;
		harr[i] = key;

		while(i != 0 && harr[parent(i)] > harr[i]){
			swap(parent(i), i);
			i = parent(i);
		}
	}

	//Returns and removes the minimum element from the heap
	public int extractMin(){
		if(heapSize == 0)
			return Integer.MAX_VALUE;
		if(heapSize == 1){
			heapSize--;
			return harr[0];
		}

		//Store the minimum value and remove it from the heap
		int min = harr[0];
		
		//Put the last value of the heap into the first
		harr[0] = harr[heapSize - 1];
		//Reduce the heapsize
		heapSize--;
		//Minheapify the array
		minHeapify(0);

		return min;
	}

	// A Recursive method to heapify a subtree with root at given index
	// This method assumes that the subtree are already heapified
	public void minHeapify(int i){
		int l = left(i);
		int r = right(i);
		int smallest = i;

		//Get the minimum from the left and right child of the index i
		if(l < heapSize && harr[l] < harr[i])
			smallest = l;
		if(r < heapSize && harr[r] < harr[smallest])
			smallest = r;
		
		//Make the recursive call only if the 
		//left or right child is smaller than root
		if(smallest != i){
			swap(smallest, i);
			minHeapify(smallest);
		}
	}

	// This function deletes key at index i. It first reduced value to minus
	// infinite, then calls extractMin()
	public void deleteKey(int i){
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}

	// Decreases value at index 'i' to newval.  It is assumed that
	// newval is smaller than harr[i].
	public void decreaseKey(int i, int newval){
		harr[i] = newval;
		while(i != 0 && harr[parent(i)] > harr[i]){
			swap(i, parent(i));
			i = parent(i);
		}
	}


}