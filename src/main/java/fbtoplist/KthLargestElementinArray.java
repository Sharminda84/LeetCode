package fbtoplist;

import java.util.PriorityQueue;

public class KthLargestElementinArray {

    public static void main(String[] args) {
        KthLargestElementinArray k = new KthLargestElementinArray();
        System.out.println(k.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for(int n : nums){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }

        }
        return heap.poll();

    }
}
