package sortandsearch;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers t = new DivideTwoIntegers();
        t.divide(10, 3);
    }

    public int divide(int dividend, int divisor) {
        int posDividend = dividend > 0 ? dividend : -1 * dividend;
        int posDivisor = divisor > 0 ? divisor : -1 * divisor;

        int count = 0;
        if(posDivisor > posDividend) return 1;

        for(int i = posDivisor; i <= dividend ; i = i + posDivisor){
            count++;
        }
        count = dividend > 0 ? count : count * -1;
        count = divisor > 0 ? count : count * -1;
        return count;
    }
}
