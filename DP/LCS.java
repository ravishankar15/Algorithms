//https://www.geeksforgeeks.org/longest-common-subsequence/
//https://www.geeksforgeeks.org/printing-longest-common-subsequence/
public class LCS{
	private int[][] lcs;
	private String x;
	private String y;

	public LCS(String x, String y){
		this.x = x;
		this.y = y;
		lcs = new int[x.length() + 1][y.length() + 1];
	}
	
	public int calcLcs(){

		//Note that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		for(int i=0; i<=x.length(); i++){
			for(int j=0; j<=y.length(); j++){
				if(i==0 || j==0)
					lcs[i][j] = 0;
				else if(x.charAt(i-1) == y.charAt(j-1))
					lcs[i][j] = 1 + lcs[i-1][j-1];
				else 
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}

		//Print the LCS Matrix
		/*for(int i=0; i<=x.length(); i++){
			for(int j=0; j<=y.length(); j++){
				System.out.print(lcs[i][j]+" ");
			}
			System.out.println();
		}*/

		return lcs[x.length()][y.length()];
	}

	public void printString(){
		int length = calcLcs();
		// Create a character array to store the lcs string
		char[] res = new char[length + 1];

		// Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
		int i = x.length(); int j = y.length(); int k = length;
		res[k--] = '\0';
		while(i > 0 && j > 0){
			//My Condition
			/*if(lcs[i][j-1] == lcs[i-1][j] && lcs[i-1][j-1] < lcs[i][j]){
				res[k--] = x.charAt(i-1);
				i--; j--;
			} */
			//Geek condition
			// If current character in X[] and Y[] are same, then
            // current character is part of LCS
			if(x.charAt(i-1) == y.charAt(j-1)){
				res[k--] = x.charAt(i-1);
				i--; j--;
			} 
			// If not same, then find the larger of two and
            // go in the direction of larger value			
			else if(lcs[i][j-1] > lcs[i-1][j])
				j--;
			else 
				i--;
		}
		System.out.println(new String(res));

	}
}