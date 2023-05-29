package stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        HashMap<Character,Character> maps=new HashMap<Character,Character>();
        maps.put(')','(');
        maps.put(']','[');
        maps.put('}','{');
        for(Character c: s.toCharArray()){
            if(maps.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != maps.get(c))return false;
            }
            else{
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
