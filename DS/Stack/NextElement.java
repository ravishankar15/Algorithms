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

	//http://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
	public int[] findMaxOfMin(int[] arr){
		int n = arr.length;
		
		//Create and auxillary stack
		Stack<Integer> st = new Stack<Integer>();

		//For stroring the previous and next smaller elements
		int[] right = new int[n];
		int[] left = new int[n];

		//Initiallize the elements for the left and right
		for(int i=0; i<n; i++){
			right[i] = n;
			left[i] = -1;
		}

		//Find the next smaller element on the left side of an element
		for(int i=0; i<n; i++){
			while(!st.isEmpty() && arr[i] <= arr[st.peek()])
				st.pop();

			if(!st.isEmpty())
				left[i] = st.peek();
			st.push(i);

		}

		//Empty the stack for furthur use
		while(!st.isEmpty())
			st.pop();

		//Find the next smaller element on the right side of an element
		for(int i=n-1; i>=0; i--){
			while(!st.isEmpty() && arr[i] <= arr[st.peek()])
				st.pop();

			if(!st.isEmpty())
				right[i] = st.peek();
			st.push(i);

		}

		//Create the answer array
		int[] ans = new int[n+1];

		//Populate the default value
		for(int i=0;i<n+1; i++)
			ans[i] = 0;


		for(int i=0; i<n; i++){
			//Length of the interval
			//This l indicates that arr[i] is minimum for the window of size l
			int l = right[i] - left[i] - 1;

			//Since we are computing the maximum of minimum we take the max of ans[l] and arr[i];
			ans[l] = Math.max(ans[l], arr[i]);
		}
		//On observing we see that ans[i] would always be greater than ans[i+1] or ans[i+2] etc
		for(int i=n-1; i>=1; i--)
			ans[i] = Math.max(ans[i], ans[i+1]);

		//We can ignore ans[0] since it does not make sense for max of min of window size 0?
		return ans;

	}


	//http://www.geeksforgeeks.org/find-next-smaller-next-greater-array/
	public int[] nextSmallOfGreat(int[] arr){
		int n = arr.length;

		//Create an empty stack and the auxillary array for 
		//the next smaller and next greater
		Stack<Integer> st = new Stack<Integer>();
		int[] ns = new int[n];
		int[] ng = new int[n];

		//Find the next smaller element
		for(int i=n-1; i>=0; i--){
			while(!st.isEmpty() && arr[st.peek()] > arr[i])
				st.pop();

			ns[i] = st.isEmpty() ? -1 : st.peek();

			st.push(i);
		}

		//Find the next greater element
		for(int i=n-1; i>=0; i--){
			while(!st.isEmpty() && arr[st.peek()] < arr[i])
				st.pop();

			ng[i] = st.isEmpty() ? -1 : st.peek();

			st.push(i);
		}

		//Compute the next smaller of next greater
		//Check -1 for index out of bound expception
		int[] res = new int[n];
		for(int i=0; i<n; i++)
			if(ng[i] != -1 && ns[ng[i]] != -1)
				res[i] = arr[ns[ng[i]]];
			else 
				res[i] = -1;

		return res;
	}
}