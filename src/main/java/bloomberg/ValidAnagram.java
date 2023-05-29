package bloomberg.arrstr;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }
        for(int i=0; i < t.length() ;i++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                int val = map.get(c)-1;
                if(val <= 0){
                    map.remove(c);
                }
                else{
                    map.put(c, val);
                }
            }
            else{
                return false;
            }
        }
        return map.size() == 0;
    }

}
