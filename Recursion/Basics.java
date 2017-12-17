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
}