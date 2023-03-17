class Trie {
    char character;
    Trie[] trieArray;
    boolean isEnd;
    Trie root = null;

    public Trie() {
        trieArray = new Trie[26];
        this.isEnd = false;
    }
    public Trie(char character) {
        
        this.character = character;
        
    }
    
    public void insert(String word) {
        int N = word.length();
        Trie temp = null;
        if(root ==null){
            root = new Trie();
        }
        temp = root;
        
        for(int i=0; i<N; i++) {
            char charAtI = word.charAt(i);
            int index = charAtI - 'a';
            if(temp.trieArray[index]==null) {
               temp.trieArray[index] = new Trie();
            }
            temp = temp.trieArray[index];
        }
        temp.isEnd = true;
        
    }
    
    public boolean search(String word) {
        int N = word.length();
        Trie temp = root;
        for(int i=0; i<N; i++) {
            char charAtI = word.charAt(i);
            int index = charAtI - 'a';
            if(temp==null || temp.trieArray[index]==null) {
               return false;
            }
            temp = temp.trieArray[index];
         }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int N = prefix.length();
        Trie temp = root;
        for(int i=0; i<N; i++) {
            char charAtI = prefix.charAt(i);
            int index = charAtI - 'a';
            if(temp==null || temp.trieArray[index]==null) {
               return false;
            }
            temp = temp.trieArray[index];
         }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */