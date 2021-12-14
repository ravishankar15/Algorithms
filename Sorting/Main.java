public class Main{
	public static void main(String[] args) {
		
		int[] arr = {5,1};
		//int[] arr = {4, 10, 3, 5, 1};


		/*SelectionSort ss = new SelectionSort();
		print(ss.sort(arr));*/

		/*BubbleSort bs = new BubbleSort();
		print(bs.sort(arr));
		print(bs.sortRecursive(arr, arr.length));*/


		/*InsertionSort is = new InsertionSort();
		print(is.sort(arr));
		print(is.sortRecursive(arr, arr.length));*/

		// MergeSort ms = new MergeSort();
		// print(ms.sortRecursive(arr, 0, arr.length-1));

		QuickSort qs = new QuickSort();
		print(qs.sortRecursive(arr, 0, arr.length-1));

		// HeapSort hs = new HeapSort();
		// print(hs.sort(arr));
	}

	public static void print(int[] arr){
		//System.out.println();
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}
}