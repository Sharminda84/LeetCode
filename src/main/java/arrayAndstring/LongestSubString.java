package arrayAndstring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println((lengthOfLongestSubStringV2("abcabcbac") == 3));
        System.out.println((lengthOfLongestSubStringV2("abcabcdbac") == 4));
        System.out.println((lengthOfLongestSubStringV2("fdfcea") == 5));
        System.out.println((lengthOfLongestSubStringV2("abcdefgaklmnw") == 12));
    }  

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int j = 0, i = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j+1);
        }
        System.out.println(s + " -> " + ans);
        return ans;
    }

    public static int lengthOfLongestSubStringV2(String s) {
        Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }

            res = Math.max(res, right - left + 1);

            chars[r] = right;
            right++;
        }

        return res;
    }
}
