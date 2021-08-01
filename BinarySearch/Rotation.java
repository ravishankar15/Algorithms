public class Rotation{

	//http://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
	public int getMinimum(int[] arr, int low, int high){

		//If the array is not rotated at all
		if(arr[low] < arr[high])
			return arr[low];

		//If there is only one element left
		if(high == low)
			return arr[low];

		//Calculate mid
		//(low+high)/2 is not prefered for mid calculation because
		//low+high can exceed the int limit
		int mid = low + (high-low)/2;

		//Check if mid+1 is the minimum element
		//If mid+1 is less than mid it would be obviously less than mid+2
		if(mid < high && arr[mid+1] < arr[mid])
			return arr[mid+1];

		//If mid+1 is not the element than mid might be the element
		if(mid > low && arr[mid-1] > arr[mid])
			return arr[mid];

		//Check if we need to go left or right
		if(arr[high] > arr[low])
			return getMinimum(arr, low, mid-1);
		return getMinimum(arr, mid+1, high);
	}

	//http://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
	//Note: This is diffrent from the above problem. The array need not be sorted
	public int getMaximum(int[] arr, int low, int high){

		//Base case only: Only one element is present
		if(low == high)
			return arr[low];

		//Only two elements are there and the first one is greater
		if(high == low+1 && arr[low] >= arr[high])
			return arr[low];

		////Only two elements are there and the second one is greater
		if(high == low+1 && arr[high] > arr[low])
			return arr[high];

		int mid = low + (high - low)/2;

		//If arr[mid] is greater than the both the adjacent element than it is the maximum
		if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1])
			return arr[mid];

		//If arr[mid] is greater than next and lesser than previous
		//The maximum lies left else it lies right
		if(arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1])
			return getMaximum(arr, low, mid-1);
		else
			return getMaximum(arr, mid+1, high);
	}
}