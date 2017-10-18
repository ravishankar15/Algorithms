import java.util.*;
public class StockSpan{
	public int[] getStockPrice(int[] arr){
		int n = arr.length();
		int[] result = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		st.push(i++);

		while(i<n){

			while(!st.isEmpty() && arr[i] < arr[st.peek()]){
				result[st.peek()] = i - st.peek();
				st.push(i++);
			}

			while(!st.isEmpty() && arr[i] > arr[st.peek()]){
				st.pop();
				i--;
			}
		}

		return result;
	}
}