class Solution {
    int result = 0;
    
    public int countSubstrings(String s) {
        int n = s.length();
        for(int i=0; i<n; i++) {
            isPalindrome(s, i, i);
            isPalindrome(s, i, i+1);
        }
        return result;
    }
    void isPalindrome(String s, int st, int en) {
        while(st>-1 && en<s.length() && s.charAt(st)==s.charAt(en)) {
            result++;
            st--;
            en++;
        }
    }
}