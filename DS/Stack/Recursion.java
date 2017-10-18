import java.util.*;
public class Recursion{

	//Method for reversing a stack
	public Stack<Integer> reverse(Stack<Integer> st){
		while(!st.isEmpty()){
			//a holds the values of the stack in the function call
			int a = st.pop();			
			reverse(st);
			return pushToStack(a, st);
		}
		return st;
	}
	//Util Method that inserts the element to the bottom of the stack
	public Stack<Integer> pushToStack(int x, Stack<Integer> st){

		/*Base condition if the stack is empty 
			inserts the value to the stack*/
		if(st.isEmpty())
			st.push(x);
		else {

			/*a holds the top of stack values in function call*/
			int a = st.pop();			
			pushToStack(x, st);

			/*Once x is inserted to the empty stack 
				the remaining elements are inserted above it*/
			st.push(a);
		}

		return st;
	}


	//Very much similar approach to reversing a stack
	public Stack<Integer> sortStack(Stack<Integer> st){

		while(!st.isEmpty()){
			int a = st.pop();
			sortStack(st);
			return insertToSortStack(st, a);
		}
		return st;
	}
	public Stack<Integer> insertToSortStack(Stack<Integer> st, int x){
		//Altering the if condition to push the element above the right one
		if(st.isEmpty() || st.peek() > x){
			st.push(x);
			return st;
		}
		else {
			int a = st.pop();
			insertToSortStack(st, x);
			st.push(a);
		}
		return st;
	}



}