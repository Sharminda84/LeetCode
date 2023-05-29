package onemoretime;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();

        int[][] input = new int[4][2];
        input[0] = new int[]{1,3};
        input[1] = new int[]{2,6};
        input[2] = new int[]{8,10};
        input[3] = new int[]{15,18};
        System.out.println(mi.merge(input));
    }

    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval: intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }
            else {
                merged.getLast()[0] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
