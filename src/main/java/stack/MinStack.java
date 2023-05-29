package stack;

import java.util.Stack;

public class MinStack {

    private Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) {

    }

    public MinStack() {

    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val, val});
            return;
        }
        int curMin = stack.peek()[1];
        stack.push(new int []{val, Math.min(curMin, val)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }


}
