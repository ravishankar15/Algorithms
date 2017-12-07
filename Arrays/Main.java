import java.util.*;
public class Main{
	public static void main(String[] args) {

		/*ArrayRotation ar = new ArrayRotation();
		print(ar.jugglingAlgorithm(new int[]{1, 2, 3, 4, 5, 6, 7}, 2));*/


		/*ArrayMath am = new ArrayMath();
		print(am.findPrime(50));*/


		ArrayArrangement aa = new ArrayArrangement();
		//System.out.println(aa.formLargestNumber(new ArrayList<String>(){{add("54"); add("546");add("548"); add("60");}}));
		//print(aa.posAndNegInAlternate(new int[] {-1, 2, -3, 4, 5, 6, -7, 8, 9}, 8));
		//print(aa.rearrangePosAndNeg(new int[] {-1, 2, -3, 4, 5, 6, -7, 8, 9},0, 8));
		print(aa.sort012(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}));

		/*ArrayCalculation ac  = new ArrayCalculation();
		System.out.println(ac.maxDiff(new int[] {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}, 10));*/
	}

	static void print(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}