package onemoretime;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {

    }

    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int currentValue = 0;
        char operation = '+';
        int i=0;
        for(Character c: s.toCharArray()){
            if(Character.isDigit(c)){
                currentValue = currentValue * 10 + (c-'0');
            }
            if(!Character.isDigit(c) || !Character.isWhitespace(c) || i == s.length()-1){
                // we have reached an operation, so we need resolve previous value accumulated
                if(operation == '+'){
                    stack.push(currentValue);
                }
                if(operation == '-'){
                    stack.push(currentValue);
                }
                if(operation == '/'){
                    stack.push(stack.pop() / currentValue);
                }
                if(operation == '*'){
                    stack.push(stack.pop() * currentValue);
                }
                operation = c;
                currentValue = 0;
            }
            i++;
        }

        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

}
