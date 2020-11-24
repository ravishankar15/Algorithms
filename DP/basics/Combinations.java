import java.util.*;
public class Combinations {

  // https://www.geeksforgeeks.org/coin-change-dp-7/
  public int coinChange(int n, int[] arr) {
    int[] r = new int[n+1];
    r[0] = 1;
    int m = arr.length;
    for(int i=0; i<m; i++) {
      for(int j=arr[i]; j<=n; j++) {
        r[j] += r[j-arr[i]];
      }
    }
    return r[n];
  }

  // https://www.geeksforgeeks.org/friends-pairing-problem/
  public int friendsPairing(int n) {
    int[] dp = new int[n+1];
    for(int i=2; i<=n; i++) {
      if (i <= 2) {
        dp[i] = i;
      }
      dp[i] = dp[i-1] + (i-1)*dp[i-2];
    }
    return dp[n];
  }


  // https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
  public boolean isSubsetSum(int sum, int[] arr) {
    int n = arr.length;
    boolean[][] dp = new boolean[n][sum+1];
    for(int i=0; i<n; i++)
      dp[i][0] = true;


    for(int i=1; i<n; i++) {
      for(int j=0; j<=sum; j++) {
        dp[i][j] = dp[i-1][j];
        if (arr[i] <= j) {
          dp[i][j] = dp[i-1][j] ? dp[i-1][j] : dp[i-1][j-arr[i]];
        }
      }
    }

    if(dp[n-1][sum])
      printSubset(arr, n-1, sum, new ArrayList<Integer>(), dp);
    return dp[n-1][sum];
  }

  private void printSubset(int[] arr, int index, int sum, List<Integer> result, boolean[][] dp) {

    if(index == 0 && sum != 0 && dp[0][sum]){
      result.add(arr[index]);
      System.out.println(result);
      result.clear();
      return;
    }

    if (index == 0 && sum == 0) {
      System.out.println(result);
      result.clear();
      return;
    }

    if (dp[index-1][sum]) {
      ArrayList<Integer> nlist = new ArrayList<>(); 
      nlist.addAll(result);
      printSubset(arr, index-1, sum, nlist, dp);
    } if (sum >= arr[index] && dp[index-1][sum - arr[index]]) {
      result.add(arr[index]);
      printSubset(arr, index-1, sum-arr[index], result, dp);
    }
  }
}