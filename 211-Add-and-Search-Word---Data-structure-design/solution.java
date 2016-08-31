public class WordDictionary {
    public class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode child[] = new TrieNode[26];
        public TrieNode() {}
        public TrieNode (char c) {
            val = c;
        }
    }
    public TrieNode root = new TrieNode();
    
    public WordDictionary () {
        root.val = ' ';
        root.isWord = false;
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.child[c-'a'] == null) 
                p.child[c-'a'] = new TrieNode(c);
            p = p.child[c-'a'];
        }
        p.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    public boolean match(char[] chs, int pos, TrieNode node) {
        if (pos == chs.length) return node.isWord;
        if (chs[pos] != '.')
            return node.child[chs[pos]-'a']!=null && match(chs, pos+1, node.child[chs[pos]-'a']);
        
        for (int i = 0; i < 26; i++) {
            if (node.child[i] == null)
                continue;
            if (match(chs, pos+1, node.child[i]))
                return true;;
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");