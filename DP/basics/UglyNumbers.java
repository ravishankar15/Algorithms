// https://www.geeksforgeeks.org/ugly-numbers/
public class UglyNumbers {

  public int solution(int n) {
    int[] u = new int[n];
    int nm2 = 2; int nm3 = 3; int nm5 = 5;
    int i2 = 0; int i3 = 0; int i5 = 0;
    u[0] = 1;
    int ugly = u[0];
    for(int i=1; i<n; i++) {
      ugly = Math.min(nm2, Math.min(nm3, nm5));
      u[i] = ugly;
      if (ugly == nm2) {
        nm2 = u[++i2] * 2;
      } if (ugly == nm3) {
        nm3 = u[++i3] * 3;
      } if (ugly == nm5) {
        nm5 = u[++i5] * 5;
      }
    }
    return ugly;
  }

}