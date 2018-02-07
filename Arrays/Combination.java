//https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
//https://www.geeksforgeeks.org/permutation-and-combination/
public class Combination{

	private int[] arr;
	private int[] data;
	private int n;
	private int r;
	public Combination(int[] arr, int r){
		this.arr = arr;
		this.r = r;
		n = arr.length;
		data = new int[r];
	}

	public void combi(int index, int i){

		if(index == r){
			for(int j=0; j<index; j++){
				System.out.print(data[j] + " ");
			}
			System.out.println();
			return;
		}


		if(i >= n)
			return;


		data[index] = arr[i];
		combi(index+1, i+1);
		combi(index, i+1);
	}

}