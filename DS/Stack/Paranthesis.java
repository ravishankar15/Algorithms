import java.util.*;
public class Paranthesis{

	//http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
	public boolean balance(String exp){
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<exp.length(); i++){
			char c = exp.charAt(i);

			if(c == '(' || c == '{' || c == '[') 
				st.push(c);

			else{
				if(st.isEmpty()){
					return false;
				} else if(!st.isEmpty() && !isPair(c, st.peek())){
					return false;
				} else {
					st.pop();
				}
			}

		}

		return st.isEmpty();
	}


	//http://www.geeksforgeeks.org/find-expression-duplicate-parenthesis-not/
	public boolean dupParanthesis(String exp){
		Stack<Character> st = new Stack<Character>();

		for(int i=0; i<exp.length(); i++){
			char c = exp.charAt(i);

			if(c == ')'){
				//Check if the immediate top is a closing paranthesis
				//If so than that is a duplicate paranthesis
				if(!st.isEmpty() && st.peek() == '(')
					return true;

				//Pop from the stack till the closing paranthesis
				while(!st.isEmpty() && st.peek() != '(')
					st.pop();

				//Pop the closing paranthesis
				st.pop();
			} else {
				//If the char is a operator or '(' than push it to stack
				st.push(c);
			}
		}
		return false;
	}


	//http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
	public int LongValidSubstring(String exp){
		int n = exp.length();
		int result = 0;
		//Create an empty stack and push the initial index to the stack
		Stack<Integer> st = new Stack<Integer>();
		st.push(-1);

		//Traverse through all the Characters
		for(int i=0; i<n; i++){
			char c = exp.charAt(i);

			//If it is a opening push it to stack
			if(c == '(')
				st.push(i);
			else {

				//Most of the time the opening paranthesis
				//If the string initial character is a closing paranthesis
				//This will be -1 e.g., )()())
				st.pop();

				if(!st.isEmpty())
					result = Math.max(result, i-st.peek());
				else 
					//If the string initial character is a closing paranthesis 
					//We nee to update the initial index e.g, )()())
					st.push(i);
			}
		}
		return result;
	}

	//http://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
	public int minReverse(String exp){
		
		//Create an empty stack
		Stack<Character> st = new Stack<Character>();
		int len = exp.length();

		//If the length is not even than it cant be balanced
		if(len%2 != 0)
			return -1;

		//Traverse all characters
		for(int i=0; i<len; i++){
			char c = exp.charAt(i);

			//If it is a openning paranthesis push it to stack
			if(c == '{')
				st.push(c);
			else {
				//If it is a closing paranthesis pop the matching 
				//Closing paranthesis
				if(!st.isEmpty() && st.peek() == '{')
					st.pop();
				//If not push to stack
				else 
					st.push(c);
			}
		}

		//Total length of the unbalanced paranthesis
		int unbal = st.size();

		//Count the number of opening paranthesis
		int n = 0;
		while(!st.isEmpty() && st.pop() == '{')
			n++;

		//The total number of reversal should be unbal/2
		//but for this case }{ to handle we added n%2
		return (unbal/2 + n%2);
	}


	//Utility method for the balancing paranthesis problem
	public boolean isPair(char c, char top){

		if(c == ')' && top == '(')
			return true;
		if(c == '}' && top == '{')
			return true;
		if(c == ']' && top == '[')
			return true;
		return false;
	}
}