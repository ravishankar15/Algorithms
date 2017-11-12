import java.util.*;
public class ArrayMath{

	//http://www.geeksforgeeks.org/sieve-of-eratosthenes/
	public int[] findPrime(int n){

		//Create a boolean array
		boolean[] prime = new boolean[n];
		int[] result = new int[n];
		int ind = 0;
		for(int i=0; i<n; i++)
			prime[i] = true;

		//Pick a Number till the sqrt of the limit
		for(int i=2; i<Math.sqrt(n); i++){

			if(prime[i] == true){
				//Identify the multiples of that number and change the boolean value
				for(int j=i*2; j<n; j+=i)
					prime[j] = false;
			}
		}

		//Store the result in the array and return it
		for(int i=2; i<n; i++){
			if(prime[i])
				result[ind++] = i;
		}
		return result;

	}
}