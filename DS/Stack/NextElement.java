import java.util.*;
public class NextElement{

	//Find the next greater element for all the elements in an array
	//If no elements found output -1
	public int[] nextGreater(int[] arr){

		int n = arr.length;
		int[] result = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for(int i=n-1; i>=0; i--){
			int temp = arr[i];
			while(!st.isEmpty() && temp > st.peek())
				st.pop();
			if(st.isEmpty()){
				result[i] = -1;
			} else {
				result[i] = st.peek();	
			}
			st.push(temp);
		}
		return result;
	}


	//Find the nearest Smaller element
	/*Given an array, find the nearest smaller element G[i] for every element A[i] 
		in the array such that the element has an index smaller than i.

	G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]

    If no smaller element found output -1*/
	public int[] nearestSmaller(int[] arr){
		int n = arr.length;
		int[] result = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0; i<n; i++){
			int temp = arr[i];
			while(!st.isEmpty() && temp < st.peek())
				st.pop();
			if(st.isEmpty())
				result[i] = -1;
			else 
				result[i] = st.peek();
			st.push(temp);
		}

		return result;
	}
}