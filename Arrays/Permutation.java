//https://stackoverflow.com/questions/30387185/print-out-all-permutations-of-an-array
//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
public class Permutation{

	private int[] arr;
	private int n;
	public Permutation(int[] arr){
		this.arr = arr;
		n = arr.length;
	}


	public void permute(int index){

		if(index == n){
			for(int i=0; i<n; i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}

		if(index > n)
			return;

		for(int i=index; i<n; i++){
			swap(index, i);
			permute(index + 1);
			swap(index, i);
		}

	}

	private void swap(int x, int y){
		int t = arr[x];
		arr[x] = arr[y];
		arr[y] = t;
	}
}