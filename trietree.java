class Trie {
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEnd;
        
        public TrieNode() {
            map = new HashMap<Character, TrieNode>();
        }
        
        public boolean contains(Character c) {
            return map.containsKey(c);
        }
        
        public TrieNode insert(Character c) {
            TrieNode node = new TrieNode();
            map.put(c, node);
            return node;
        }
        
        public void setIsEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
        
        public TrieNode get(Character c) {
            return map.get(c);
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.isEnd = true;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (search(word)) {
            return;
        }
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.contains(c)) {
                p = p.get(c);
            } else {
                p = p.insert(c);
            }
        }
        p.setIsEnd(true);
    }
    
    public TrieNode innerSearch(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.contains(c)) {
                p = p.get(c);
            } else {
                return null;
            }
        }
        return p;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = innerSearch(word);
        if (p!=null && p.isEnd()) {
            return true;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = innerSearch(prefix);
        if (p!=null) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
