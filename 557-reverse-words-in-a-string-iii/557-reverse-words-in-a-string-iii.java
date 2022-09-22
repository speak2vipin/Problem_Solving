class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        if(words.length==1) {
            return new String(reverseString(s.toCharArray(), 0, s.length()-1));
        }
        int N = words.length-1;
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<words.length-1;i++){
             result.append(new String(reverseString(words[i].toCharArray(), 0, words[i].length()-1))).append(" ");
        }
         result.append(new String(reverseString(words[N].toCharArray(), 0, words[N].length()-1)));
        
        return result.toString();
        
    }
    
    char[] reverseString(char[] array, int initial, int last) {
        if(initial>=last) {
            return array;
        }
        char temp = array[initial];
        array[initial] = array[last];
        array[last] = temp;
        return reverseString(array, initial+1, last-1);
    }
    
}