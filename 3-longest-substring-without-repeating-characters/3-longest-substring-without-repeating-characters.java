class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashChar = new HashSet<Character> ();
        int len = 0;
        int j = 0;
        for(int i=0; i<s.length(); i++) {
            char c= s.charAt(i);
            if(!hashChar.contains(c)){
                hashChar.add(c);
                len = len>hashChar.size() ? len : hashChar.size();
            } else {
                hashChar.remove(s.charAt(j++));
                i--;
            }
        }
        return len;
    }
}