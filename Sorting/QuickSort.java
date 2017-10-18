public class QuickSort{

	//http://www.geeksforgeeks.org/quick-sort/
	public int[] sortRecursive(int[] arr, int low, int high){
		if(low<high){

			//pi is partition index, arr[p] is at right place
			int pi = partition(arr, low, high);

			//Separately sort elements before partition 
			//and after partition
			sortRecursive(arr, low, pi-1);	
			sortRecursive(arr, pi+1, high);
		}
		return arr;
	}

	/* This function takes last element as pivot, places
	   the pivot element at its correct position in sorted
	    array, and places all smaller (smaller than pivot)
	   to left of pivot and all greater elements to right
	   of pivot */
	public int partition(int[] arr, int low, int high){

		int pivot = arr[high]; //Pivot
		int i = low - 1; //Index of smaller element

		for(int j = low; j<high; j++){
			// If current element is smaller than pivot
			if(arr[j] < pivot){
				i++; // increment index of smaller element
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		//place pivot at correct position by swapping arr[i+1]
		//and arr[high] (or pivot) 
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;

		return i+1;
	}
}