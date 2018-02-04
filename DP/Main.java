public class Main{
	public static void main(String[] args) {
		Basic basic = new Basic();

		/*System.out.println(basic.recursiveFibo(10));
		System.out.println(basic.memoizationFibo(10));
		System.out.println(basic.tablulationFibo(10));
		System.out.println(basic.recursiveSolve(6));
		System.out.println(basic.memoizationSolve(6));*/


		LCS lcs = new LCS(new String("AGGTAB"), new String("GXTXAYB"));
		System.out.println(lcs.calcLcs());
		lcs.printString();
	}
}