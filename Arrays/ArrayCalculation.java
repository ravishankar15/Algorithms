public class ArrayCalculation{

	//http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
	public int maxDiff(int[] arr, int n){
		
		int[] rmax = new int[n];
		int[] lmin = new int[n];

		/* Construct lmin[] such that lmin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
		lmin[0] = arr[0];
		for(int i=1; i<n; i++)
			lmin[i] = Math.min(arr[i], lmin[i-1]);

		/* Construct rmax[] such that rmax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
		rmax[n-1] = arr[n-1];
		for(int i=n-2; i>=0; i--)
			rmax[i] = Math.max(arr[i], rmax[i+1]);


		/* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
		int i=0; int j=0; int maxDiff = -1;
		while(j<n && i<n){
			if(lmin[i] < rmax[j]){
				maxDiff = Math.max(maxDiff, j-i);
				j++;
			} else{
				i++;
			}

		}

		return maxDiff;

	}
}