//http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
import java.util.*;
public class LargeRectHistogram{

	public int getArea(int[] arr){

		/* The stack holds the indexes of the bar 
			The bars should always be in the increasing order */
		Stack<Integer> st = new Stack<Integer>();
		int n = arr.length;
		int i = 0; int area = 0; int max_area = 0;
		while(i<n){

			/* If the bar is higher than the bar on top of stack, 
				push it to stack */
			if(st.isEmpty() || arr[i] >= arr[st.peek()]){
				st.push(i);
				i++;
			} 
			/* If the bar is lower than the top of stack 
				calculate the area of rectangle with stack top as smallest 
				i - right index; element before the stack top is left index */
			else {
				int top = st.pop();
				//Calculate the area with the top bar as smallest
				area = arr[top] * (st.isEmpty() ? i : i - st.peek() - 1);

				//Update the max area
				max_area = area > max_area ? area : max_area;
			}

		}

		/* If more elements are in the stack pop those elements 
			calculate the area and update the max area */
		while(!st.isEmpty()){
			int top = st.pop();
			area = arr[top] * (st.isEmpty() ? i : i - st.peek() - 1);
			max_area = area > max_area ? area : max_area;
		}

		return max_area;

	}

	/*This is simplified version and is very much 
		similar to the trapping rain water problem solution */
	public int getAreaSimplified(int[] arr){
		/* The stack holds the indexes of the bar 
			The bars should always be in the increasing order */
		Stack<Integer> st = new Stack<Integer>();
		int n = arr.length;
		int i = 0; int area = 0; int max_area = 0;
		while(i<n){
			while(!st.isEmpty() && arr[i] < arr[st.peek()]){
				int top = st.pop();
				if(st.isEmpty())
					break;

				//Calculate the area with the top bar as smallest
				area = arr[top] * (st.isEmpty() ? i : i - st.peek() - 1);

				//Update the max area
				max_area = area > max_area ? area : max_area;

			}
			st.push(i);
			i++;
		}

		return max_area;
	}
}