package fbtoplist;

import java.util.*;

public class RemoveInvalidParanthsis {

    public static void main(String[] args) {
        String s = "()())()";

        for(String t: removeInvalidParentheses(s)){
            System.out.println(t);
        }
    }

    public static boolean isValid(String s){
        int count = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if ( c == '(') count ++;
            if ( c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);
        boolean found = false;
        while(!queue.isEmpty()) {
            s = queue.poll();

            if(isValid(s)){
                res.add(s);
                found = true;
            }

            if(found) continue;

            for(int i = 0; i < s.length(); i++){

                if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0,i) + s.substring(i+1); // String with removed char at pos i

                if(!visited.contains(t)){
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
    }
}
