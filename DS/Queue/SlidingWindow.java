//http://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
import java.util.*;
public class SlidingWindow{
	public void maximum(int[] arr, int k){

		//Create a double ended queue with 
		//The maximum value in front
		//The minimum value in rear
		Deque<Integer> dq = new LinkedList<Integer>();
		int i;
		for(i=0; i<k; i++){

			//Since we need to find the maximum remove 
			//the elements smaller than the current from the last of queue
			while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
				dq.removeLast();

			dq.add(i);
		}
		for(; i<arr.length; i++){

			System.out.print(arr[dq.peek()]+" ");

			//Remove the elements which are out of window
			//i-k considers the last k elements from the current position i
			//Hence elements before that are out of our window
			while(!dq.isEmpty() && dq.peek() <= i-k)
				dq.removeFirst();

			//Since we need to find the maximum remove 
			//the elements smaller than the current from the last of queue
			while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
				dq.removeLast();

			//Add the new element to queue
			dq.add(i);

		}

		System.out.print(arr[dq.peek()]+" ");


	}
}