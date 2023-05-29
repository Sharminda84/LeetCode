package fbtoplist;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println('a' > '9');

        validWordAbbreviation("internationalization", "i12iz4n");
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }

    public boolean isPalindrome(String s) {
        for(int i =0,j=s.length()-1; i <j; i++,j--){
            while(i < j && ! Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && ! Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) !=
               Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }
}
