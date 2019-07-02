//http://www.geeksforgeeks.org/trapping-rain-water/
import java.util.*;
public class TrappingRainWater{

	/*Calculating using the precomputed left and right 
		maximum values for each index Time: O(n); Space O(n)*/
	public int trapArray(int[] arr){

		int n = arr.length;
		int vol = 0;
		int[] left = new int[n];
		int[] right = new int[n];

		/* Contains the height of the tallest 
			bar to the left of current for all bars*/
		left[0] = arr[0];
		for(int i=1; i<n; i++)
			left[i] = Math.max(arr[i], left[i-1]);

		/* Contains the height of the tallers 
			bar to the right of current for all bars*/
		right[n-1] = arr[n-1];
		for(int i=n-2; i>=0; i--)
			right[i] = Math.max(arr[i], right[i+1]);

		/* The water can be trapped only to the minimum height of 
			two bars Subracting arr[i] is to less the floor size e.g., in [3, 2, 3]
			The amout of water stored is 1 the floor 2 should be lessed when calculating 
			the volume */
		for(int i=0; i<n; i++){
			vol += Math.min(left[i], right[i]) - arr[i];
		}

		return vol;
	}

	/* Calculating using the two pointers for the left and right 
		Time: O(n); Space: O(1)*/
	public int trapWithoutExtraSpace(int[] arr){
		
		//Maximum of left and right
		int left_max = Integer.MIN_VALUE;
		int right_max = Integer.MIN_VALUE;

		//Index for traversing
		int left=0; int right = arr.length - 1;
		int vol = 0;
		while(left <= right){

			//If left is minimum
			if(arr[left] < arr[right]){
				//Update left max
				if(arr[left] > left_max){
					left_max = arr[left];
				} else {
					/*Right is high than left hence leftmax - arr[left] 
						gives the water trapped in the current position*/
					vol += left_max - arr[left];
					left++;
				}
			} 
			//Right is minimum
			else {
				//Update right max
				if(arr[right] > right_max){
					right_max = arr[right];
				} else {
					/*Left is high than right hence rightmax - arr[right]
						gives the water trapped in the current position*/
					vol += right_max - arr[right];
					right--;
				}
			}
		}
		return vol;
	}

	/*This is one more solution very similar to the 
		Largest area of the histogram bar solution*/
	public int trapStack(int[] arr){

		/* The stack holds the indexes of the bar 
			The bars should always be in the decresing order */
		Stack<Integer> st = new Stack<Integer>();
		int i = 0; int n = arr.length;
		int vol = 0;

		//Skiping the initial zeros
		while(st.isEmpty() && arr[i] == 0)
			i++;

		while(i<n){
			while(!st.isEmpty() && arr[i] > arr[st.peek()]){
				int top = st.pop();
				if(st.isEmpty())
					break;

				//Summing the vol of the water trapped
				//Since the maximum water saved is the minimum height of the bar
				//we are taking the min
				vol += (i - st.peek() - 1) * (Math.min(arr[i], arr[st.peek()]) - arr[top]);
			}
			st.push(i);
			i++;
		}
		return vol;
	}
}