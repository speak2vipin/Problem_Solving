class Solution {
    Trie root = null;
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String d : dictionary) {
            formTrie(d);
        }
        String sen[] = sentence.split(" ");
        for(int i=0; i<sen.length; i++) {
            sen[i] = traverse(sen[i]);
        }
        String res = "";
        for(String s : sen) {
            res += s + " ";
        }
        return res.trim();
        
    }
    
    String traverse(String s) {
        Trie temp = root;
        
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i)-'a';
            if(temp.trie[index]==null) {
                return s;
            } else {
                
                temp = temp.trie[index];
                if(temp.isDone) {
                    return s.substring(0, i+1);
                }
            }
        }
       return s;
    }
    
    void formTrie(String s) {
        Trie temp = null;
        if(root == null) {
            root = new Trie();
        }
        temp = root;
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i)-'a';
            if(temp.trie[index]==null) {
                temp.trie[index] = new Trie();
            }
            temp = temp.trie[index];
        }
        temp.isDone = true;        
    }
}


class Trie {
    Trie trie[];
    boolean isDone;
    public Trie() {
        trie = new Trie[26];
        isDone = false;
    }
}