import java.util.*;
public class ArrayArrangement{

	//http://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
	public String formLargestNumber(ArrayList<String> list){

		//We compare two numbers x appended to y 
		//and y appended to x
		Collections.sort(list, new Comparator<String>(){

			@Override
			public int compare(String x, String y){
				String xy = x+y;
				
				String yx = y+x;

				return yx.compareTo(xy);
			}
		});

		String result = "";
		for(String s: list)
			result = result + s;

		return result;
	}

	//http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
	public int[] posAndNegInAlternate(int[] arr, int n){

		//Similar to Quick sort take 0 as the pivot point
		int pivot = 0;

		//Initial Smaller value index as -1
		int i = -1;

		//Similar to quick sort partitioning
		for(int j=0; j<n; j++){

			if(arr[j] < pivot){
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		//At this point the negative values will be in the begining 
		//and the positive in the end
		
		//Take the starting index of the positive and negative value
		int pos = i+1; int neg = 0;

		//Rearrange the array alternatively
		while(pos < n && neg < pos && arr[neg] < 0){
			int temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg+=2;
		}

		return arr;
	}


	//http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/
	public int[] rearrangePosAndNeg(int[] arr, int low, int high){
		//This is similar to merge sort
		if(low < high){
			int mid = low + (high - low)/2;

			//Sort first and second half recursively
			rearrangePosAndNeg(arr, low, mid);
			rearrangePosAndNeg(arr, mid+1, high);

			merge(arr, low, mid, high);
		}

		return arr;
	}
	//Utility method
	public void merge(int[] arr, int low, int mid, int high){
		
		//Calculate the size of left and right subarrays
		int n1 = mid - low + 1;
		int n2 = high - mid;

		int[] left = new int[n1];
		int[] right = new int[n2];

		//Copy values to the left and right sub arrays
		for(int i=0; i<n1; i++)
			left[i] = arr[low+i];
		for(int i=0; i<n2; i++)
			right[i] = arr[mid+1+i];

		int i=0; int j=0; int k=low;

		//Note order of elements should be maintained - 
		//We copy elements from left subarray and than the right subarray

		//copy negative values from left subarray
		while(i<n1 && left[i] < 0)
			arr[k++] = left[i++];

		//copy negative values from right subarray
		while(j<n2 && right[j] < 0)
			arr[k++] = right[j++];

		//copy positive values from left subarray
		while(i<n1)
			arr[k++] = left[i++];

		//copy positive values from right subarray
		while(j<n2)
			arr[k++] = right[j++];
	}
}