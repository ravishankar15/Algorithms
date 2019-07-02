public class Main{
	public static void main(String[] args) {
		Basic basic = new Basic();

		//System.out.println(basic.recursiveFibo(10));
		//System.out.println(basic.memoizationFibo(10));
		//System.out.println(basic.tablulationFibo(10));
		//System.out.println(basic.recursiveSolve(6));
		// System.out.println(basic.memoizationSolve(6));


		/*LCS lcs = new LCS(new String("AGGTAB"), new String("GXTXAYB"));
		System.out.println(lcs.calcLcs());
		lcs.printString();*/

		/*LRS lrs = new LRS(new String("aabb"));
		System.out.println(lrs.calcLrs());
		lrs.printString();*/

		/*SqrSubMatrix ssm =  new SqrSubMatrix(new int[][] {{0, 1, 1, 0, 1}, 
									                      {1, 1, 0, 1, 0}, 
									                      {0, 1, 1, 1, 0},
									                      {1, 1, 1, 1, 0},
									                      {1, 1, 1, 1, 1},
									                      {0, 0, 0, 0, 0}});
		ssm.calculate();
		ssm.printMatrix();*/


		/*LIS lis = new LIS(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 });
		System.out.println(lis.calculate());*/
		/*lis.printLis();*/

		/*MinCostPath mcp = new MinCostPath(new int[][] {{1, 2, 3},
								                       {4, 8, 2},
								                       {1, 5, 3}}, 2, 2);
		System.out.println(mcp.calculate());*/


    LCString lcString = new LCString();
    // System.out.println(lcString.longestCommonSubString("caba", "abac"));
    System.out.println(lcString.longestCommonSubSequence("AGGTAB", "GXTXAYB")); //"ABCDGH", "AEDFHR"
    lcString.printLongestCommonSubSequence("AGGTAB", "GXTXAYB"); //"AGGTAB", "GXTXAYB"
	}
}