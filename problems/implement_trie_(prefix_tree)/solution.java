class Trie {
    
    private static final char EMPTY_CHAR = '\0';
    
    class TrieNode {
        private final Map<Character, TrieNode> children;
        private boolean terminal;
        
        public TrieNode() {
            this.children = new HashMap<>();
            this.terminal = false;
        }
        
        public boolean hasChild(Character key) {
            return children.containsKey(key);
        }
        
        public TrieNode getChild(Character key) {
            return children.get(key);
        }
        
        public TrieNode addChild(Character key) {
            TrieNode child = new TrieNode();
            children.put(key, child);
            return child;
        }
        
        public boolean isTerminal() {
            return terminal;
        }
        
        public void setTerminal(boolean terminal) {
            this.terminal = terminal;
        }
    }
    
    class SearchResult {
        private final int wordIndex;
        private final TrieNode lastNode;
        
        public SearchResult(int wordIndex, TrieNode lastNode) {
            this.wordIndex = wordIndex;
            this.lastNode = lastNode;
        }
        
        public TrieNode getLastNode() {
            return lastNode;
        }
        
        public int getWordIndex() {
            return wordIndex;
        }
    }

    private final TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        SearchResult searchResult = searchWord(word);
        TrieNode node = searchResult.getLastNode();
        int wordIndex = searchResult.getWordIndex();
        
        while (wordIndex < word.length()) {
            node = node.addChild(word.charAt(wordIndex++));
        }
        
        node.setTerminal(true);
    }
    
    public boolean search(String word) {
        SearchResult searchResult = searchWord(word);
        TrieNode node = searchResult.getLastNode();
        int wordIndex = searchResult.getWordIndex();
        
        return wordIndex == word.length() && node.isTerminal();
    }
    
    private SearchResult searchWord(String word) {
        TrieNode node = root;
        int wordIndex = 0;
        while (node != null && wordIndex < word.length()) {
            char currentChar = word.charAt(wordIndex);
            if (node.hasChild(currentChar)) {
                node = node.getChild(currentChar);
            } else {
                break;
            }
            wordIndex++;
        }
        return new SearchResult(wordIndex, node);
    }
    
    public boolean startsWith(String prefix) {
        SearchResult searchResult = searchWord(prefix);
        TrieNode node = searchResult.getLastNode();
        int wordIndex = searchResult.getWordIndex();
        
        return wordIndex == prefix.length();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */