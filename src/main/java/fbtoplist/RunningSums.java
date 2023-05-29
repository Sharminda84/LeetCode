package fbtoplist;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RunningSums {

    public static void main(String[] args) {
        RunningSums rs = new RunningSums();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.poll();
        rs.checkSubarraySum(new int[]{23,2,4,6,7}, 6);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }
}
