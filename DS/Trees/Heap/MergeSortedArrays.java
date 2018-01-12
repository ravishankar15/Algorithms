//https://www.geeksforgeeks.org/merge-k-sorted-arrays/
public class MergeSortedArrays{

	private int[] result; //Result Array
	private int n;
	private int k;
	private HeapNode[] harr; //Heap Array

	public MergeSortedArrays(int n, int k){
		result = new int[n*k];
		harr = new HeapNode[k];
		this.n = n;
		this.k = k;
	}

	private HeapNode getMin(){
		return harr[0];
	}

	public void mergeArrays(int[][] arr){

		//create a heap with k node with every 
		//heap node has the first element of an array
		for(int i=0; i<k; i++){
			HeapNode hn = new HeapNode(arr[i][0], i, 1);
			harr[i] = hn;
		}
		constructHeap(); //Construct heap

		//One by one get the minimum element from the heap and replace it with 
		//the next element in the array
		for(int count = 0; count < n*k; count++){

			//Get the minimum element and store it in the array
			HeapNode root = getMin(); 
			result[count] = root.getElement();

			//Find the next element that will replace the 
			//next element for the current node
			if(root.getJ() < n){
				root.setElement(arr[root.getI()][root.getJ()]);
				root.setJ(root.getJ() + 1);
			} else {
				root.setElement(Integer.MAX_VALUE);
			}

			//Replace the minimum with root
			harr[0] = root;
			//Minheapify the heap
			minHeapify(0);

		}

		for(int i=0; i<n*k; i++){
			System.out.print(result[i]+" ");
		}

	}

	public void constructHeap(){
		for(int i=k/2-1; i>=0; i--)
			minHeapify(i);
	}

	public void minHeapify(int i){
		int l = (2*i) + 1;
		int r = (2*i) + 2;
		int smallest = i;

		if(l < k && harr[l].getElement() < harr[i].getElement())
			smallest = l;
		if(r < k && harr[r].getElement() < harr[smallest].getElement())
			smallest = r;

		if(smallest != i){

			HeapNode temp = harr[i];
			harr[i] = harr[smallest];
			harr[smallest] = temp;

			minHeapify(smallest);

		}

	}

}

class HeapNode{
	private int element; //The element of the node
	private int i; //Index of the array from which the element is taken
	private int j; //Index of the next element to be picked from the array

	public HeapNode(int element, int i, int j){
		this.element = element;
		this.i = i;
		this.j = j;
	}

	public void setElement(int element){
		this.element = element;
	}

	public int getElement(){
		return this.element;
	}

	public void setI(int i){
		this.i = i;
	}

	public int getI(){
		return this.i;
	}

	public void setJ(int j){
		this.j = j;
	}

	public int getJ(){
		return this.j;
	}
}