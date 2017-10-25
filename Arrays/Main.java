public class Main{
	public static void main(String[] args) {

		ArrayRotation ar = new ArrayRotation();
		print(ar.jugglingAlgorithm(new int[]{1, 2, 3, 4, 5, 6, 7}, 2));

	}

	static void print(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}