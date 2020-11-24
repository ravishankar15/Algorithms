public class Tiling {

  // https://www.geeksforgeeks.org/tiling-problem/
  public int tiling2n(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2; i<=n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }

  // https://www.geeksforgeeks.org/tiling-with-dominoes/
  public int tiling3n(int n) {
    int[] a = new int[n+1];
    int[] b = new int[n+1];
    a[0] = 1; a[1] = 0;
    b[0] = 0; b[1] = 1;
    for(int i=2; i<=n; i++) {
      a[i] = a[i-2] + 2 * b[i-1];
      b[i] = a[i-1] + b[i-2];
    }
    return a[n];
  }
}