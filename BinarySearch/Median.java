public class Median{

	//http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
	//Ref: http://www.sanfoundry.com/java-program-find-median-array-using-binary-search-approach/
	//Note: The array length needs to be same
	public int getMedianOfTwo(int[] arr1, int[] arr2, int low1, int high1, int low2, int high2){
		int mid1 = low1 + (high1-low1)/2;
		int mid2 = low2 + (high2-low2)/2;

		if(high1 - low1 == 1)
			return (Math.max(arr1[low1], arr2[low2]) + Math.min(arr1[high1], arr2[high2]))/2;


		else if(arr1[mid1] > arr2[mid2])
			return getMedianOfTwo(arr1, arr2, low1, mid1, mid2, high2);

		else
			return getMedianOfTwo(arr1, arr2, mid1, high1, low2, mid2);

	}

}