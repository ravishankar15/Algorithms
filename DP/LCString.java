public class LCString {

  //https://www.geeksforgeeks.org/longest-common-substring-dp-29/
  public int longestCommonSubString(String a, String b) {
    int m = a.length();
    int n = b.length();
    char [] a_arr = a.toCharArray();
    char [] b_arr = b.toCharArray();
    int [][] lcss = new int[m+1][n+1];
    int result = 0;
    for(int i=0; i<=m; i++) {
      for(int j=0; j<=n; j++){
        if(i==0 || j==0){
          lcss[i][j] = 0;
        } else if(a_arr[m-i] == b_arr[n-j]){
          lcss[i][j] = lcss[i-1][j-1] + 1;
          result = Math.max(result, lcss[i][j]);
        } else {
          lcss[i][j] = 0;
        }
      }
    }
    return result;
  }

  //https://www.geeksforgeeks.org/longest-common-subsequence/
  public int longestCommonSubSequence(String a, String b) {
    int m = a.length();
    int n = b.length();
    char [] a_arr = a.toCharArray();
    char [] b_arr = b.toCharArray();
    int [][] lcss = new int[m+1][n+1];
    for(int i=0; i<=m; i++) {
      for(int j=0; j<=n; j++) {
        if(i==0 || j==0){
          lcss[i][j] = 0;
        } else if(a_arr[i-1] == b_arr[j-1]){
          lcss[i][j] = lcss[i-1][j-1] + 1;
        } else {
          lcss[i][j] = Math.max(lcss[i][j-1], lcss[i-1][j]);
        }
      }
    }

    //Print the LCS Matrix
    /*for(int i=0; i<=m; i++){
      for(int j=0; j<=n; j++){
        System.out.print(lcss[i][j]+" ");
      }
      System.out.println();
    }*/

    return lcss[m][n];
  }

  public void printLongestCommonSubSequence(String a, String b) {
    // Calculate the longest common sub sequence
    int m = a.length(); int n = b.length();
    char [] a_arr = a.toCharArray(); char [] b_arr = b.toCharArray();
    int [][] lcss = new int[m+1][n+1];
    for(int i=0; i<=m; i++) {
      for(int j=0; j<=n; j++) {
        if(i==0 || j==0){
          lcss[i][j] = 0;
        } else if(a_arr[i-1] == b_arr[j-1]){
          lcss[i][j] = lcss[i-1][j-1] + 1;
        } else {
          lcss[i][j] = Math.max(lcss[i][j-1], lcss[i-1][j]);
        }
      }
    }
    // Calculate the longest common sub sequence

    int k = lcss[m][n]; int i=m; int j=n;
    char[] res = new char[k + 1]; 
    res[k--] = '\0';
    while(i>0 && j>0){
      if(a.charAt(i-1) == b.charAt(j-1)) {
        res[k--] = a.charAt(i-1);
        i--; j--;
      } else if (lcss[i][j-1] > lcss[i-1][j]){
        j--;
      } else {
        i--;
      }
    }
    System.out.println(new String(res));
  }

  //This is a brute force approach - gives better understanding on DP
  //Time - o(n^2) space - o(n^2)
  public String longestPalindromic(String s) {
    if(s == null || "".equals(s)){
      return s;
    }
    int length = s.length();
    String ans = null; int max = 0;
    boolean[][] dp = new boolean[length][length];
    for(int i=0; i<length; i++) {
      for(int j=0; j<=i; j++) {
        boolean match = s.charAt(i) == s.charAt(j);
        dp[j][i] = i-j > 2 ? dp[j+1][i-1] && match : match;

        if(dp[j][i] && i-j+1 > max){
          max = i-j+1;
          ans = s.substring(j, i+1);
        }
      }
    }
    //Print the dp Matrix
    // for(int i=0; i<length; i++){
    //   for(int j=0; j<length; j++){
    //     System.out.print(dp[i][j]+" ");
    //   }
    //   System.out.println();
    // }
    return ans;
  }

  //Time - o(n^2) space - o(1)
  public String lpExpandAroundCorner(String s) {
    if(s==null || "".equals(s)) return s;
    int start = 0, end = 0;
    FunctionalInterface fi = (String t, int l, int r) -> {
      while(l>=0 && r < t.length() && t.charAt(l) == t.charAt(r)) {
        l--; 
        r++;
      }
      return r-l-1;
    };

    for(int i=0; i<s.length(); i++) {
      int len1 = fi.expAroundCorner(s, i, i);
      int len2 = fi.expAroundCorner(s, i, i+1);
      int len = Math.max(len1, len2);
      // 1 is added to get the first match and remove 1 for the latest match
      if(len > end - start + 1) {
        start = i - (len-1)/2;
        end = i + len/2;
      }
    }
    return s.substring(start, end+1);
  }
}

interface FunctionalInterface {
  public int expAroundCorner(String t, int l, int r);
}