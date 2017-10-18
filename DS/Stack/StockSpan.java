//http://www.geeksforgeeks.org/the-stock-span-problem/
import java.util.*;
public class StockSpan{
	public int[] getStockPrice(int[] arr){
		int n = arr.length;
		int[] result = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;

		//The result of 1st element is always 1 
		//since no element is before that
		result[i] = 1;

		//Push the first element into the stack
		st.push(i++);
		while(i<n){

			//Pop the elements from the stack if top of stack 
			//is less than or equal to arr[i]
			while(!st.isEmpty() && arr[i] >= arr[st.peek()])
				st.pop();

			// If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1]. Else price[i]
            // is greater than elements after top of stack
			result[i] = st.isEmpty() ? i+1 : i - st.peek();

			//Push the current element into the stack
			st.push(i++);	
			
		}
		return result;
	}
}