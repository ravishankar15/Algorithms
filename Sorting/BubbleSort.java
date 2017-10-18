public class BubbleSort{
	//http://www.geeksforgeeks.org/recursive-bubble-sort/
	public int[] sort(int[] arr){
		int n = arr.length;

		for(int i=0; i<n; i++){

			//Flag to check if any swapping happend
			boolean flag = false;

			for(int j=0; j<n-i-1; j++){

				//If the current value is greater than next value swap it
				if(arr[j] > arr[j+1]){
					flag = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}

			}
			//If no swapping had happend than the arr is sorted 
			//hence we can break the loop
			if(!flag)
				break;
		}
		return arr;
	}

	//http://www.geeksforgeeks.org/recursive-bubble-sort/
	public int[] sortRecursive(int[] arr, int n){

		//Base condition
		if(n==1)
			return arr;
		//One pass will move the largest element to the end
		for(int i=0; i<n-1; i++){
			if(arr[i] > arr[i+1]){
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}

		//Largest element is fixed recur for the remaining
		return sortRecursive(arr, n-1);
	}
}