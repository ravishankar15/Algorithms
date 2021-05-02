import java.util.*;
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        for (int i = 1, j = 0; i < dp.length; i++) {
            if (i != days[j]) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = dp[i - 1] + costs[0];
            dp[i] = Math.min(dp[i], i >= 7 ? dp[i - 7] + costs[1] : costs[1]);
            dp[i] = Math.min(dp[i], i >= 30 ? dp[i - 30] + costs[2] : costs[2]);
            j++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }


    public void printDp(int[][]arr){
      for (int i=0;i<arr.length; i++) {
        for (int j=0;j<arr[0].length; j++) {
          System.out.print(arr[i][j] + " ");
        }
        System.out.println();
      }
    }
}

public class Hello {
  // Driver code 
    public static void main(String args[]) 
    { 
        // Solution s = new Solution();
        // System.out.println(s.mincostTickets(new int[] {1,4,6,7,8,20}, new int[] {2,7,15}));
      System.out.println(Optional.of("parentId").map(f -> f.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2").replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase()).get());
      System.out.println("parentId".replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2").replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase());
    }
}