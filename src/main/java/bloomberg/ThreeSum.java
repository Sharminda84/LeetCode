package bloomberg.arrstr;

import java.util.*;

public class ThreeSum {
    //Given an integer array nums, return all the triplets
    //[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    //
    //Notice that the solution set must not contain duplicate triplets.
    //Input: nums = [-1,0,1,2,-1,-4]
    //Output: [[-1,-1,2],[-1,0,1]]
    //Explanation:
    //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    //The distinct triplets are [-1,0,1] and [-1,-1,2].
    //Notice that the order of the output and the order of the triplets does not matter.

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> seen = new HashMap<>();
        Set<Integer> dups = new HashSet<>();
        for(int i = 0; i < nums.length ;i++){
            if(dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int complement = -nums[i] - nums[j];
                    if(seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
        return  result;
    }
}
