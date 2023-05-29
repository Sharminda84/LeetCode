package onemoretime;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer i: nums){
            if(!map.containsKey(i)){
                map.put(i, 0);
            }
            map.put(i, map.get(i)+1);
        }

        PriorityQueue<Pair<Integer,Integer>> heap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        for(Integer key: map.keySet()){
            heap.offer(new Pair(key, map.get(key)));
            if(heap.size() > k){
                heap.poll();
            }
        }

        return heap.stream().map(kk -> {
            return kk.getKey();
        }).collect(Collectors.toList());
    }
}
