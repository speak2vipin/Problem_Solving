class Solution {
    public int firstUniqChar(String s) {
        
        int index[] = new int[26];
        char[] sArray = s.toCharArray();
        for(char temp : sArray) {
            index[temp-'a'] += 1; 
        }
        for(char temp : sArray) {
            if(index[temp-'a']==1) {
                return s.indexOf(temp);
            }
        }
        return -1;
    
        
    }
}