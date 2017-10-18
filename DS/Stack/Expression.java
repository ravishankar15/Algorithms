import java.util.*;
public class Expression{

	//Convert an Infix Expression to Postfix Expression
	public String infixToPostFix(String exp){
		Stack<Character> st = new Stack<Character>();
		String result = new String("");
		for(int i=0; i<exp.length(); i++){
			char c = exp.charAt(i);

			// If the character is an operand than add it to result
			if(Character.isLetterOrDigit(c)){
				result+=c;
			} else if(c == '('){ // If it is a openning add it to stack
				st.push(c);
			} else if(c == ')'){ // If it is a closing pop stack till the opening braces
				while(!st.isEmpty() && st.peek() != '('){
					result+=st.pop();
				}
				st.pop();
			} else {

				//If it an operator we can push it to the stack only
				//If the top of stack contains lesser precedence than the scanner character
				//Else we need to pop the stack till we get an operator of lesser precedence than the scanned
				while(!st.isEmpty() && precedence(c) <= precedence(st.peek())){
					result+=st.pop();
				} 
				//Finally push the scanned operator to the stack
				st.push(c);
			}

		}

		while(!st.isEmpty())
			result+=st.pop();

		return result;

	}

	//Evaluates the post fix expression
	public int evalPostFixExpr(String exp){

		Stack<Integer> st = new Stack<Integer>();
		for(int i=0; i<exp.length(); i++){
			char c = exp.charAt(i);
			if(Character.isDigit(c)){
				//When we have a char that represents a ASCII/Unicode digit like('1') and 
				//we subtract the smallest possible ASCII/unicode digit from it (e.g. '0'), 
				//then we will be left with the digit's corresponding value (hence, 1)
				//Me still Not clear on this ?
				st.push(c - '0');
			} else {
				int a = st.pop();
				int b = st.pop();

				switch(c){
					case '+':{
						st.push(b+a);
						break;
					}
					case '-':{
						st.push(b-a);
						break;
					}
					case '*':{
						st.push(b*a);
						break;
					}
					case '/':{
						st.push(b/a);
						break;
					}
				}

			}

		}

		return st.pop();

	}

	//Utility methods 
	//Returns the precedence of operator
	public int precedence(char c){
		switch(c){
			case '+':
			case '-':
				return 1;

			case '*':
			case '/':
				return 2;

			case '^':
				return 3;
		}

		return -1;
	}

}