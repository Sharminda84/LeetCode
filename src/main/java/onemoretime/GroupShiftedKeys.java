package onemoretime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedKeys {

    public static void main(String[] args) {

    }

    public List<List<String>> groupStrings(String[] strings){
        HashMap<String, List<String>>  map = new HashMap<>();

        for(String s: strings){
            String hash = hash(s);
            if(!map.containsKey(hash)){
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for(String key: map.keySet()){
            result.add(map.get(key));
        }

        // time (N strings elements * K (max size of string)

        return result;
    }

    private String hash(String s){
        StringBuilder sb = new StringBuilder();
        char[] chArray = s.toCharArray();
        for(int i=1;i<s.length();i++){
            sb.append((chArray[i]-chArray[i-1]+26)%26 + 'a');
        }

        return sb.toString();
    }
}
