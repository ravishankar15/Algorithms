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