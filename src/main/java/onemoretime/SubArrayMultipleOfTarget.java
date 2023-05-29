package onemoretime;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SubArrayMultipleOfTarget {

    public static void main(String[] args) {
        System.out.println(checkSubArraySum(new int[]{23,2,4,6,7}, 6));
        
    }
    //For e.g. in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0].
    // We got remainder 5 at index 0 and at index 3.
    // That means, in between these two indexes we must have added a number which is multiple of the k. Hope this clarifies your doubt :)

    public static boolean checkSubArraySum(int[] sum, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int runningSum = 0;
        for(int i =0; i < sum.length;i++){
            runningSum += sum[i];
            if(k != 0) {
                runningSum %= k;
            }
            Integer prev = map.get(runningSum);
            if ( prev != null) {
                if ( i - prev > 1) return true;
            }
            else {
                map.put(runningSum, i);
            }
        }

        return false;
    }
}
