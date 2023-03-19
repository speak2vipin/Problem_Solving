class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie('\u0000');
    }
    
    public void addWord(String word) {
        Trie temp = root;
        int N = word.length();
        for(int i=0; i<N; i++) {
            char tempLetter = word.charAt(i);
            int index = tempLetter - 'a';
            if(temp.trieArray[index]==null) {
                temp.trieArray[index] = new Trie(tempLetter);
            }
            temp = temp.trieArray[index]; 
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie temp = root;
        int N = word.length();
        char[]letters = word.toCharArray();
        for(int i=0; i<N; i++) {
            char tempLetter = letters[i];
            int index = 0;
            if(tempLetter!='.') {
                index = tempLetter - 'a';
                if(temp.trieArray[index]==null) {
                    return false;
                }
                temp = temp.trieArray[index]; 
            } else {
                for(char j='a'; j<='z'; j++) {
                    letters[i] = j;
                    if(search(new String(letters))) {
                        return true;
                    }
                }
                return false;
            }      
        }
        return temp.isEnd;
    }
}

class Trie {
    char letter;
    Trie [] trieArray;
    boolean isEnd;
    public Trie(char letter) {
        this.letter = letter;
        this.trieArray = new Trie[26];
        this.isEnd = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */