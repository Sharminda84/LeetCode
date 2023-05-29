package fbtoplist;

public class CustomSortString {

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "xyadnbhjc"));
    }

    public static String customSortString(String order, String s) {
        // first count number of occurances of characters in s
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        // add the char in s in the orders its present.
        for(char c: order.toCharArray()){
            for(int i=0; i < count[c-'a'];i++){
                sb.append(c);
            }
            count[c-'a'] = 0;
        }

        //add remaining characters
        for(char c: s.toCharArray()){
            for(int i=0; i < count[c-'a'];i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
