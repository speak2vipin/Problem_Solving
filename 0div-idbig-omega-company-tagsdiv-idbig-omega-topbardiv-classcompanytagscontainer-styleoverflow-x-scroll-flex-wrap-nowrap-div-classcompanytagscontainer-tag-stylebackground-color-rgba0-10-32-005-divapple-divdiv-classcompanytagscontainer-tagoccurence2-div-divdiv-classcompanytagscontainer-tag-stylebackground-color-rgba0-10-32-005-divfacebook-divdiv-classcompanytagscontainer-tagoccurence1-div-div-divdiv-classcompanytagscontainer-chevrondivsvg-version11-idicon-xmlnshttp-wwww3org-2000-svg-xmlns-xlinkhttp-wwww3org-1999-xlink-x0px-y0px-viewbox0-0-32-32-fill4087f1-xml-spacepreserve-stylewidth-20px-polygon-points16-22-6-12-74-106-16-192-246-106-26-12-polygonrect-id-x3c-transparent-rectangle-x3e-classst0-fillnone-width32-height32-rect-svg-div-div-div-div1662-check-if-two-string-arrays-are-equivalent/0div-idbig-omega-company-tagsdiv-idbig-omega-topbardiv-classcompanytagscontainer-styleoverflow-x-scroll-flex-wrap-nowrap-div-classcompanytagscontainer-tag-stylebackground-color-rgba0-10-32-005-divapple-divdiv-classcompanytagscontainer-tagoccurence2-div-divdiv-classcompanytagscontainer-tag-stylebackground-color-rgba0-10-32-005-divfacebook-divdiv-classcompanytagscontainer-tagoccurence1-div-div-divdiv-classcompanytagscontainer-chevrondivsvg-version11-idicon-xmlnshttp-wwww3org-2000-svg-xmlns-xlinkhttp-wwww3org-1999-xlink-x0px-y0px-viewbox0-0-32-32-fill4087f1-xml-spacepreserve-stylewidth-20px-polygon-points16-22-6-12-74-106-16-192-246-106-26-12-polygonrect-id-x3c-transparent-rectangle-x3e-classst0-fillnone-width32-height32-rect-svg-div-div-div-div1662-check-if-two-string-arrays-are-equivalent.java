class Solution {
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();  
        StringBuilder sb2 = new StringBuilder();  
        for(String word : word1) {
            sb1.append(word);
        }
        for(String word : word2) {
            sb2.append(word);
        }
        return sb1.toString().equals(sb2.toString());
    }
    
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int word1Pointer = 0, string1Pointer = 0;
        int word2Pointer = 0, string2Pointer = 0;
        
        while(word1Pointer<word1.length && word2Pointer<word2.length) {
            
            if(word1[word1Pointer].charAt(string1Pointer++)
                        != word2[word2Pointer].charAt(string2Pointer++)) {
                return false;
            }
            if(word1[word1Pointer].length()==string1Pointer) {
                word1Pointer++;
                string1Pointer = 0;
            }
            if(word2[word2Pointer].length()==string2Pointer) {
                word2Pointer++;
                string2Pointer = 0;
            }
        }
        return word1Pointer==word1.length && word2Pointer==word2.length;
    }
}