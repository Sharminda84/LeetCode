package bloomberg.arrstr;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String[] args) {
        LongestSubString c = new LongestSubString();
        System.out.println(c.lengthOfLongestSubstring("abba"));;
        //abcabc = 3
        //bbbbb = 1
        //pwwkew = 3
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int start = -1;

        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                start = Math.max(map.get(c),start);
            }
            int diff = i - start;
            result = Math.max(result, diff);
            map.put(c, i);
        }

        return result;
    }
}
