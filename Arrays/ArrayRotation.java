public class ArrayRotation{
	//http://www.geeksforgeeks.org/array-rotation/
	public int[] jugglingAlgorithm(int[] arr, int d){
		int n = arr.length;
		int gcd = GCD(n, d);
		int j,k;
		for(int i=0; i<gcd; i++){
			//Store the first value in temp
			int temp = arr[i];
			j = i;
			while(true){
				k = j+d;
				//If k goes greater than n subract n so that the value reaches i
				if(k >= n)
					k = k-n;

				//If k is equal to i than we can break the loop
				if(k==i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			//Place the first element of the bucket in correct position
			arr[j] = temp;
		}

		return arr;
	}

	//Utility function for finding the GCD of the numbers
	public int GCD(int a, int b){
		if(b == 0)
			return a;
		return GCD(b, a%b);
	}
}