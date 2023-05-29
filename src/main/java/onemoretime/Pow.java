package onemoretime;

public class Pow {

    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println(p.myPow(2.0, 3));
    }

    public double myPow(double x, int n){
        return recursivePow(x,n);
    }

    private double recursivePow(double x, int n){
        if(n == 1) return x;

        double half = recursivePow(x, n/2);
        if(n % 2 == 0) return half * half;
        else return half * half * x;
    }
}
