class Solution {
    public int firstUniqChar(String s) {
        int index[] = new int[26];
        for(int i=0; i<s.length(); i++) {
            index[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); i++) {
            if(index[s.charAt(i)-'a']==1) {
                return i;
            }
        }
        return -1;
    }
}