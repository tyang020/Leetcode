class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    // Initialize your data structure here.
    public TrieNode() {}
    public TrieNode(char c) {
        this.val = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if(p.children[c-'a'] == null)
                p.children[c-'a'] = new TrieNode(c);
            p = p.children[c-'a'];
        }
        p.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.children[c-'a'] == null)
                return false;
            p = p.children[c-'a'];
        }
        return p.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            if (p.children[c-'a'] == null)
                return false;
            p = p.children[c-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");