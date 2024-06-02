class Solution {
    public void reverseString(char[] s) {
        helper(s, 0, s.length-1, '\u0000');
    }
    
    void helper(char[] s, int st, int en, char temp) {
        if(st<en) {
            temp = s[st];
            s[st] = s[en];
            s[en] = temp;
            helper(s, ++st, --en, temp);
        }
    }
}