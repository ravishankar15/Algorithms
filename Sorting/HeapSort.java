//https://www.geeksforgeeks.org/heap-sort/
public class HeapSort{

	public int[] sort(int[] arr){
		int n = arr.length;

		//Build the heap
		for(int i=n/2-1; i>=0; i--){
			heapify(arr, n, i);
		}

		//One by one extract the element from the heap
		for(int i=n-1; i>=0; i--){

			//Swap the first element with the last element
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			heapify(arr, i, 0);
		}

		return arr;

	}

	//Heapify the tree between n and i
	public void heapify(int[] arr, int n, int i){
		int largest = i; //Assume the current value of index as largest
		int l = (2*i) + 1; //Get the left child index
		int r = (2*i) + 2; //Get the right child index

		//Calculate the largest among the child(left or right)
		if(l < n && arr[l] > arr[largest])
			largest = l;
		if(r < n && arr[r] > arr[largest])
			largest = r;

		//If the largest is not the parent i.e., Either left or right child
		if(largest != i){

			//Swap the parent with the child largest value
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}

	}
}