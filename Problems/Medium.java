import java.util.*;
public class Medium {
  /* 
  https://leetcode.com/problems/longest-substring-without-repeating-characters/
  */
  public int lengthOfLongestSubString(String s) {
    int n = s.length();
    Map<Character, Integer> map = new HashMap<>();
    int ans =0; int i=0; int j=0;
    for(i=0, j=0; j<n; j++) {
      if(map.containsKey(s.charAt(j))){
        i = Math.max(map.get(s.charAt(j)), i);
      }
      ans = Math.max(ans, j-i+1);
      map.put(s.charAt(j), j+1);
    }
    return ans;
  }


  public double twoSortedArrayMedian(int[] arr1, int[] arr2) {
    if(arr1.length > arr2.length) {
      return twoSortedArrayMedian(arr2, arr1);
    }
    int x = arr1.length; int y = arr2.length;
    int low = 0; int high = x;
    while(low <= high) {
      partitionX = (low + high)/2;
      partitionY = (x + y + 1)/2 - partitionX;

      int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : arr1[partitionX - 1];
      int minRightX = partitionX == x ? Integer.MAX_VALUE : arr1[partitionX];

      int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : arr2[partitionY - 1];
      int minRightY = partitionY == y ? Integer.MAX_VALUE : arr2[partitionY];

      if(maxLeftX <= minRightY && maxLeftY <= minRightX){
        if((x+y)%2 == 0){
          return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
        } else {
          return (double)Math.max(maxLeftX, maxLeftY);
        }
      } else if(maxLeftX > minRightY) {
        high = partitionX - 1;
      } else {
        low = partitionX + 1;
      }
    }
    return 0.0; 
  }
}