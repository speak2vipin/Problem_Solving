class MagicDictionary {
    Set<String> discSet;

    public MagicDictionary() {
            discSet = new HashSet<String>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s : dictionary) {
            discSet.add(s);
        }
    }
    
    public boolean search(String searchWord) {
        for(String s : discSet) {
            if(returnSeqNumber(searchWord,s)) {
                return true;
            }
        }
        return false;
    }
    
    boolean returnSeqNumber(String s, String s2) {
        int count = 0;
        int []cA = new int[26];
        int length1 = s.length();
        int length2 = s2.length();
        if(length1!=length2) {
            return false;
        } else {
            for(int i=0; i<s.length();i++) {
                if(s.charAt(i)==s2.charAt(i)) {
                    continue;
                } else {
                    count++;
                    if(count>1) {
                        break;
                    }
                }
            }  
        }
        
        return count==1? true : false;
       
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */