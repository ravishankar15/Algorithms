//http://www.geeksforgeeks.org/the-celebrity-problem/
import java.util.*;
public class Celebrity{
	private int KNOW_MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
    private int n = 4;

	public int findCelebStack(){

		Stack<Integer> st = new Stack<Integer>();

		//Push everything to stack
		for(int i = 0; i<n; i++)
			st.push(i);

		while(st.size() > 1){

			//Pop of two person from the stack
			//Remove one person based on the return of knows
			int a = st.pop();
			int b = st.pop();

			//Push the remainded person to stack
			if(knows(a, b))
				st.push(b);
			else
				st.push(a);
		}
		int ceb = st.pop();

		//Check if the person is a celebrity or not
		for(int i = 0; i<n; i++){

			//If any person dosent know the ceb or ceb dosent know anyone
			//than he cant be the celebrity hence return -1
			if(i != ceb && (knows(ceb,i) || !knows(i, ceb)))
				return -1;
		}

		return ceb;

	}


	//Utility Method that return true if a knows b
	public boolean knows(int a, int b){
		return (KNOW_MATRIX[a][b] == 1) ? true : false;
	}

}