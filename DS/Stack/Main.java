import java.util.*;
public class Main{
	public static void main(String[] args) {

		int[] arr = {6, 2, 5, 4, 5, 1, 6};
		Stack<Integer> st = new Stack<Integer>();
		st.push(4); st.push(5); st.push(2); st.push(10); st.push(8);

		//Expression related stack problems
		/*Expression expr = new Expression();
		System.out.println(expr.infixToPostFix("a+b*(c^d-e)^(f+g*h)-i"));//Converts an Infix Expression to Postfix Expression
		System.out.println(expr.evalPostFixExpr("231*+9-")); //Evaluates the post fix expression*/

		//Manipulation using the next and nearest element in an array
		//NextElement ne = new NextElement();
		//print(ne.nextGreater(arr)); //Find the next Greater element
		//print(ne.nearestSmaller(arr)); //Find the nearest Smaller element
		//print(ne.findMaxOfMin(new int[] {10, 20, 30, 50, 10, 70, 30}));
		//print(ne.nextSmallOfGreat(new int[]{5, 1, 9, 2, 5, 1, 7}));

		//Stack Problems using Recursion
		/*Recursion recur = new Recursion();
		//print(recur.reverse(st)); //Reversing a stack using recursion
		//print(recur.sortStack(st)); //Sorting a stack*/


		/*LargeRectHistogram lrh = new LargeRectHistogram();
		System.out.println(lrh.getArea(arr));
		System.out.println(lrh.getAreaSimplified(arr));*/
		


		/*TrappingRainWater trap = new TrappingRainWater();
		System.out.println(trap.trapArray(new int[]{0, 1, 0, 1, 2}));
		System.out.println(trap.trapWithoutExtraSpace(new int[]{0, 1, 0, 1, 2}));
		System.out.println(trap.trapStack(new int[]{0, 1, 0, 1, 2}));*/		

		/*StockSpan ss = new StockSpan();
		print(ss.getStockPrice(new int[]{10, 4, 5, 90, 120, 80}));*/

		/*Celebrity ceb = new Celebrity();
		System.out.println(ceb.findCelebStack());
		System.out.println(ceb.findCelebTwoPoint());*/

		//Paranthesis par = new Paranthesis();
		/*System.out.println(par.balance("[()]{}{[()()]()}"));
		System.out.println(par.dupParanthesis("((a+(b))+(c+d))"));
		System.out.println(par.LongValidSubstring("()(()))))"));*/
		//System.out.println(par.minReverse("{{{{"));

	}

	public static void print(int[] arr){
		//System.out.println();
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}

	public static void print(Stack<Integer> st){
		while(!st.isEmpty()){
			System.out.print(st.pop()+" ");
		}
	}
}