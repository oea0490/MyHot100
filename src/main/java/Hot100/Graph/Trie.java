package Hot100.Graph;

class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int n = word.length();
        TrieNode cur = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        int n = word.length();
        TrieNode cur = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode cur = root;
        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}
