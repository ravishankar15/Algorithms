public class InsertionSort{
	//http://www.geeksforgeeks.org/insertion-sort/
	public int[] sort(int[] arr){
		int n = arr.length;
		for(int i=1; i<n;i++){
			int key = arr[i];
			int j = i-1;
			/* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
			while(j>=0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		return arr;
	}

	//http://www.geeksforgeeks.org/recursive-insertion-sort/
	public int[] sortRecursive(int[] arr, int n){

		//Base case
		if(n<=1)
			return arr;

		//Sort 0 to n-1 elements
		sortRecursive(arr, n-1);

		//Insert last element at its correct position
		//in sorted array
		int key = arr[n-1];
		int j = n-2;
		/* Move elements of arr[0..i-1], that are
           greater than key, to one position ahead
           of their current position */
		while(j>=0 && arr[j] > key){
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = key;

		return arr;
	}
}