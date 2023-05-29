package Trie;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
    class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        ReplaceWords rw = new ReplaceWords();
        System.out.println(rw.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }

    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root : roots) {
            TrieNode cur = trie;
            for (char letter : root.toCharArray()) {
                if (cur.children[letter - 'a'] == null) {
                    cur.children[letter - 'a'] = new TrieNode();
                }
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word : sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode cur = trie;
            for (char letter : word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null)
                    break;
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
   }
}
