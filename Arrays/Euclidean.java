public class Euclidean {

    private int x;
    private int y;


    public void calculate(int a, int b){
        //System.out.println(basic(a, b));
        System.out.println(extended(a,b));
        System.out.println(x + "," + y);
    }

    private int basic(int a, int b) {
        if (a == 0) {
            return b;
        }
        return basic(b%a, a);
    }

    private int extended(int a, int b){

        if(a == 0){
            x = 0;
            y = 1;
            return b;
        }
        int gcd = extended(b%a, a);
        int x1=x; int y1=y;
        x = y1 - (b/a) * x1;
        y = x1;

        return gcd; 


    }


}