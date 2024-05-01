class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        StringBuilder sb = 
            new StringBuilder(word.substring(0, index+1)).reverse().append(word.substring(index+1));
        return index==-1? word:sb.toString();
        
    }
}