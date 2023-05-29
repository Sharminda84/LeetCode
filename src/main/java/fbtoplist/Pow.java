package fbtoplist;

public class Pow {

    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println(p.myPow(2.0, 4));
        System.out.println(p.myPow(2.0, 5));
    }

    public double myPow(double x, int n){
        long N = n;
        if(N < 0) {
            x = 1/x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n){
        if(n == 0) return 1.0;

        double half = fastPow(x, n / 2);
        if( n % 2 == 0) return half * half;
        else return half * half * x;
    }

}
