public class Basics{
	//http://www.geeksforgeeks.org/practice-questions-for-recursion-set-2/
	//Note: This is a non tailed recursive function.
	public void printBinary(int n){
		if(n==0)
			return;
		printBinary(n/2);
		System.out.print(n%2);
	}

	//http://www.geeksforgeeks.org/practice-questions-for-recursion-set-3/
	public void triangleStar(int n){
		if(n > 1)
			triangleStar(n-1);
		for(int i=0; i<n; i++)
			System.out.print("*");
		System.out.println();
	}

	//http://www.geeksforgeeks.org/practice-questions-for-recursion-set-3/
	private final int LIMIT = 1000;
	public void printMulOfN(int n){
		if(n <= 0)
			return;
		if(n > LIMIT)
			return;
		System.out.print(n+" ");
		printMulOfN(n*2);
		System.out.print(n+" ");

	}

	//http://www.geeksforgeeks.org/practice-questions-for-recursion-set-4/
	public int getMax(int[] arr, int n){
		int x;
		if(n == 1)
			return arr[0];
		else
			x = getMax(arr, n-1);
		if(x > arr[n-1])
			return x;
		else
			return arr[n-1]; 
	}

	//Recursive fibonacci
	public int fibo(int n){
		if(n <= 1)
			return n;
		return fibo(n-1) + fibo(n-2);
	}

	//Recursive factorial
	public int fact(int n){
		if(n == 1)
			return 1;
		return n * fact(n-1);
	}

	//Calculate the GCD of two numbers
	public int gcd(int a, int b){
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}

}