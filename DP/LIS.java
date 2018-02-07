//https://www.geeksforgeeks.org/longest-increasing-subsequence/
import java.util.*;
public class LIS{

	private int[] arr;
	private int[] lis;
	private int n;
	private ArrayList<ArrayList<Integer>> lis_val;

	public LIS(int[] arr){
		this.arr = arr;
		n = arr.length;
		lis = new int[n];
		Arrays.fill(lis, 1);
		lis_val = new ArrayList<ArrayList<Integer>>();
	}

	public int calculate(){
		
		for(int i=0; i<n; i++){
			for(int j=0; j<i; j++){
				//Initially the LIS of all the array values is 1
				if(i==0)
					lis[i] = 1;
				else if(arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}

		/*for(int i=0; i<n; i++)
			System.out.print(lis[i]+" ");*/
		int max_val = lis[0];
		for(int i=1; i<n; i++){
			if(max_val < lis[i]){
				max_val = lis[i];
			}
		}
		return max_val;

	}


	/*public void printLis(){

		for(int i=0; i<n; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(arr[i]);
			lis_val.add(temp);
		}

		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j] && lis_val.get(i).size() < lis_val.get(j).size() + 1)
					lis_val.get(i).add(arr[j]);
			}
			//lis_val.get(i).add(arr[i]);
		}

		ArrayList<Integer> max = new ArrayList<Integer>();
		max = lis_val.get(0);
		for(int i=1; i<n; i++)
			max = lis_val.get(i).size() > max.size() ? lis_val.get(i) : max;

		System.out.println(max);


	}*/
}