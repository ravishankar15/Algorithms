public class CeilingAndFloor{

	//http://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
	public int getCeiling(int[] arr, int low, int high, int x){

		//If x is smaller than first than return first element
		if(x <= arr[low])
			return arr[low];

		//If x is greater than the last element return -1
		if(x > arr[high])
			return -1;


		int mid = low + (high - low)/2;

		//If x is same as mid element return the mid  element
		if(arr[mid] == x) 
			return arr[mid];
		//If x is greater than arr[mid] than ceiling is mid+1 
		//or it lies in right side of array
		else if(x > arr[mid]){
			if(mid+1 <= high &&  x <= arr[mid+1])
				return arr[mid+1];
			else
				return getCeiling(arr, mid+1, high, x);
		} 
		//If x is smaller than arr[mid] than ceiling is mid-1 
		//or it lies in left side of array
		else{
			if(mid-1 >= low && x > arr[mid-1])
				return arr[mid];
			else
				return getCeiling(arr, low, mid-1, x);
		}

	}

	//http://www.geeksforgeeks.org/floor-in-a-sorted-array/
	public int getFloor(int[] arr, int low, int high, int x){

		if(low > high)
			return -1;

		//If the last element is greater than high return high
		if(x >= arr[high])
			return arr[high];

		int mid = low + (high - low)/2;
		
		//If the middle element is the floor
		if(arr[mid] == x)
			return arr[mid];
		
		//If x lies between mid-1 and mid
		if(mid > 0 && arr[mid-1] <= x && x < arr[mid])
			return arr[mid - 1];

		//If x is smaller than mid floor must be in the left half
		//Else it should be in the right
		if(x < arr[mid])
			return getFloor(arr, low, mid-1, x);
		return getFloor(arr, mid+1, high, x);
	}
}