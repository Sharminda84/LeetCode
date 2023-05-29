package onemoretime;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestElementInAnArray {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public static int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });

        for(Integer i: nums) {
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }
}
