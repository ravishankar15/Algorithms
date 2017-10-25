public class CountOccurences{
	//http://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
	public int getCount(int[] arr, int x){

		//Get the start index of the number
		int start = getFirstAndLastOcc(arr, x, true);

		//Get the end index of the number
		int end = getFirstAndLastOcc(arr, x, false);

		//Return (end - start)+1 since array index start from 0
		return (end - start)+1;
	}

	//Utility method to find the First and last occurance of the given number using the boolean flag
	public int getFirstAndLastOcc(int[] arr, int x, boolean flag){
		int low = 0;
		int high = arr.length - 1;
		int result = -1;
		while(low <= high){
			int mid = low + (high - low)/2;
			if(arr[mid] == x){
				result = mid;
				if(flag)
					//If flag is true move towards the left 
					//i.e., The first occurence
					high = mid - 1;
				else
					//Else move towards right
					//i.e, The last occurence
					low = mid + 1;
			} else if(arr[mid] > x){
				high = mid - 1;
			} else{
				low = mid + 1;
			}
		}
		return result;
		
	}
}