//https://www.geeksforgeeks.org/longest-repeating-subsequence/
//https://www.geeksforgeeks.org/longest-repeated-subsequence/
public class LRS{
	private int[][] lrs;
	private String x;

	public LRS(String x){
		this.x = x;
		lrs = new int[x.length() + 1][x.length() + 1];
	}

	public int calcLrs(){
		//Note that L[i][j] contains length of LRS of X[0..i-1] and Y[0..j-1]
		for(int i=0; i<=x.length(); i++){
			for(int j=0; j<=x.length(); j++){
				if(i==0 || j==0)
					lrs[i][j] = 0;
				//The index should not be same
				else if(x.charAt(i-1) == x.charAt(j-1) && i != j)
					lrs[i][j] = lrs[i-1][j-1] + 1;
				else
					lrs[i][j] = Math.max(lrs[i][j-1], lrs[i-1][j]);
			}
		}
		return lrs[x.length()][x.length()];
	}

	//Print the LRS Matrix
	/*for(int i=0; i<=x.length(); i++){
		for(int j=0; j<=y.length(); j++){
			System.out.print(lrs[i][j]+" ");
		}
		System.out.println();
	}*/

	public void printString(){
		int length = calcLrs();
		// Create a character array to store the lrs string
		char[] res = new char[length + 1];

		// Start from the right-most-bottom-most corner and
        // one by one store characters in lrs[][]
		int i=length; int j=length; int k = length;
		res[k--] = '\0';
		while(i > 0 && j > 0){
			// If current character in X[] and Y[] are same, then
            // current character is part of LCS
			if(x.charAt(i-1) == x.charAt(j-1)){
				res[k--] = x.charAt(i-1);
				i--; j--;
			} 
			// If not same, then find the larger of two and
            // go in the direction of larger value	s
			else if(lrs[i][j-1] > lrs[i-1][j])
				j--;
			else 
				i--;
		}
		System.out.println(new String(res));

	}
}