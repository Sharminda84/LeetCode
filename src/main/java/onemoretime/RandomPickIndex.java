package onemoretime;

import java.util.*;

public class RandomPickIndex {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Random random = new Random();

    public static void main(String[] args) {
        RandomPickIndex rpi = new RandomPickIndex(new int[]{1,2,3,3,3});
        System.out.println(rpi.pick(3));
    }

    public RandomPickIndex(int[] nums) {
        int idx = 0;
        for(Integer n: nums){
            if(!map.containsKey(n)){
                map.put(n, new ArrayList<>());
            }
            map.get(n).add(idx++);
        }
    }

    public int pick(int target) {
        int elements = map.get(target).size();
        return map.get(target).get(random.nextInt(elements));
    }
}
