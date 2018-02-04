//https://www.geeksforgeeks.org/dynamic-programming-set-1/
import java.util.*;
public class Basic{

	private int[] lookup;
	public Basic(){
		lookup = new int[100];
		Arrays.fill(lookup, -1);
		Arrays.fill(dp, -1);
	}

	public int recursiveFibo(int n){
		if(n <= 1)
			return n;
		return recursiveFibo(n-1) + recursiveFibo(n-2);
	}
	
	public int memoizationFibo(int n){
		if(lookup[n] == -1){
			if(n <= 1)
				lookup[n] = n;
			else
				lookup[n] = memoizationFibo(n-1) + memoizationFibo(n-2);
		}
		return lookup[n];
	}

	public int tablulationFibo(int n){
		int[] fibo = new int[n+1];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2; i<=n; i++)
			fibo[i] = fibo[i-1] + fibo[i-2];
		return fibo[n];
	}


	/*Given 3 numbers {1, 3, 5}, we need to tell
	the total number of ways we can form a number 'N' 
	using the sum of the given three numbers.
	(allowing repetitions and different arrangements).
	Total number of ways to form 6 is : 8
	1+1+1+1+1+1
	1+1+1+3
	1+1+3+1
	1+3+1+1
	3+1+1+1
	3+3
	1+5
	5+1*/
	public int recursiveSolve(int n){
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;
		return recursiveSolve(n-1) + recursiveSolve(n-3) + recursiveSolve(n-5);
	}
	private int[] dp = new int[100];
	public int memoizationSolve(int n){
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;

		if(dp[n] != -1)
			return dp[n];

		dp[n] = memoizationSolve(n-1) + memoizationSolve(n-3) + memoizationSolve(n-5);
		return dp[n];
	}


}