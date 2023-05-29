package fbtoplist;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class OceanView {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(findBuildings(new int[]{1,3,2,4})).stream().map(i -> String.valueOf(i)).collect(Collectors.toList()));
    }

    public static int[] findBuildings(int[] heights) {
        if(heights == null || heights.length == 0) return new int[0];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        for(int i = 1; i < heights.length; i++){
            if(heights[stack.peek()] <= heights[i]){
                stack.pop();
                while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]){
                    stack.pop();
                }
            }
            stack.push(i);
        }

        int[] result = new int[stack.size()];
        for(int i = stack.size() -1 ; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
