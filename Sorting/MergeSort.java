//http://www.geeksforgeeks.org/merge-sort/
public class MergeSort{

	public int[] sortRecursive(int[] arr, int l, int r){
		if(l<r){

			//Find the middle element
			int m = (l+r)/2;

			//Sort the first and second halves
			sortRecursive(arr, l, m);
			sortRecursive(arr, m+1, r);

			//Merge the sorted halves
			merge(arr, l, r, m);
		}

		return arr;
	}

	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
	public void merge(int[] arr, int l, int r, int m){
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		//Auxilary arrays for left and right 
		int[] left = new int[n1];
		int[] right = new int[n2];

		//Copy data to temp arrays
		for(int i=0; i<n1; i++)
			left[i] = arr[l+i];

		for(int i=0; i<n2; i++)
			right[i] = arr[m+1+i];

		/*Merging the sub arrays*/

		//Initial index of temp arrays
		int i=0; int j=0; 

		//Initial index of merged array
		int k = l;

		while(i<n1 && j<n2){
			if(left[i] <= right[j]){
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}

		while(i<n1){
			arr[k] = left[i];
			i++;
			k++;
		}

		while(j<n2){
			arr[k] = right[j];
			j++;
			k++;
		}

	}

}