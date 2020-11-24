public class LongestSequence {

  // https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
  public String longestCommonSubsequence(String a, String b) {
    char[] ar = a.toCharArray();
    char[] br = b.toCharArray();
    int al = a.length();
    int bl = b.length();
    int dp[][] = new int[al+1][bl+1];
    for(int i=0; i<=al; i++) {
      for(int j=0; j<=bl; j++) {
          if (i==0 || j==0) {
            dp[i][j] = 0;
          } else if (ar[i-1] == br[j-1]) {
            dp[i][j] = dp[i-1][j-1] + 1;
          } else {
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
          }
      }
    }
    int max_length = dp[al][bl];
    System.out.println("The maximum length " + max_length);
    
    // Print the sequence
    int k = max_length;
    char[] lcsString = new char[k+1];
    int i=al; int j=bl;
    lcsString[k--] = '\0';
    while(i>0 && j>0) {
      if (ar[i-1] == br[j-1]) {
        lcsString[k--] = ar[i-1];
        i--;
        j--;
      } else if (dp[i][j-1] > dp[i-1][j]) {
        j--;
      } else {
        i--;
      }
    }
    return new String(lcsString);
  }

  // https://www.geeksforgeeks.org/longest-repeated-subsequence/
  public String longestRepetedSubsequence(String a, String b) {
    char[] ar = a.toCharArray();
    char[] br = b.toCharArray();
    int al = a.length();
    int bl = b.length();
    int dp[][] = new int[al+1][bl+1];
    for(int i=0; i<=al; i++) {
      for(int j=0; j<=bl; j++) {
          if (i==0 || j==0) {
            dp[i][j] = 0;
          } else if (ar[i-1] == br[j-1] && i-1 != j-1) {
            dp[i][j] = dp[i-1][j-1] + 1;
          } else {
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
          }
      }
    }
    int max_length = dp[al][bl];
    System.out.println("The maximum length " + max_length);
    
    // Print the sequence
    int k = max_length;
    char[] lcsString = new char[k+1];
    int i=al; int j=bl;
    lcsString[k--] = '\0';
    while(i>0 && j>0) {
      if (dp[i][j] == dp[i-1][j-1] + 1) {
        lcsString[k--] = ar[i-1];
        i--;
        j--;
      } else if (dp[i][j] == dp[i-1][j]) {
        i--;
      } else {
        j--;
      }
    }
    return new String(lcsString);
  }

  // https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
  public int longestIncreasingSubsequence(int[] arr) {
    int len = arr.length;
    int dp[] = new int[len];
    int max = 0;

    for(int i=0; i<len; i++)
      dp[i] = 1;

    for(int i=1; i<len; i++) {
      for(int j=0; j<i; j++) {
        if (arr[i] > arr[j] && dp[i] < dp[j] + 1)
          dp[i] = dp[j] + 1;
      }
    }
    for (int i=0; i<len; i++) {
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}