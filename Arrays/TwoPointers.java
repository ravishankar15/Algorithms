public class TwoPointers {
  //https://leetcode.com/problems/container-with-most-water/
  public int maxWaterContainer(int[] arr) {
    int length = arr.length;
    int l = 0;
    int r = length - 1;
    int ma = 0;
    while(l<=r){
      int ca = Math.min(arr[l], arr[r]) * (r-l);
      ma = Math.max(ma, ca);
      if(arr[l] < arr[r])
        l++;
      else
        r--;
    }
    return ma;
  }
}