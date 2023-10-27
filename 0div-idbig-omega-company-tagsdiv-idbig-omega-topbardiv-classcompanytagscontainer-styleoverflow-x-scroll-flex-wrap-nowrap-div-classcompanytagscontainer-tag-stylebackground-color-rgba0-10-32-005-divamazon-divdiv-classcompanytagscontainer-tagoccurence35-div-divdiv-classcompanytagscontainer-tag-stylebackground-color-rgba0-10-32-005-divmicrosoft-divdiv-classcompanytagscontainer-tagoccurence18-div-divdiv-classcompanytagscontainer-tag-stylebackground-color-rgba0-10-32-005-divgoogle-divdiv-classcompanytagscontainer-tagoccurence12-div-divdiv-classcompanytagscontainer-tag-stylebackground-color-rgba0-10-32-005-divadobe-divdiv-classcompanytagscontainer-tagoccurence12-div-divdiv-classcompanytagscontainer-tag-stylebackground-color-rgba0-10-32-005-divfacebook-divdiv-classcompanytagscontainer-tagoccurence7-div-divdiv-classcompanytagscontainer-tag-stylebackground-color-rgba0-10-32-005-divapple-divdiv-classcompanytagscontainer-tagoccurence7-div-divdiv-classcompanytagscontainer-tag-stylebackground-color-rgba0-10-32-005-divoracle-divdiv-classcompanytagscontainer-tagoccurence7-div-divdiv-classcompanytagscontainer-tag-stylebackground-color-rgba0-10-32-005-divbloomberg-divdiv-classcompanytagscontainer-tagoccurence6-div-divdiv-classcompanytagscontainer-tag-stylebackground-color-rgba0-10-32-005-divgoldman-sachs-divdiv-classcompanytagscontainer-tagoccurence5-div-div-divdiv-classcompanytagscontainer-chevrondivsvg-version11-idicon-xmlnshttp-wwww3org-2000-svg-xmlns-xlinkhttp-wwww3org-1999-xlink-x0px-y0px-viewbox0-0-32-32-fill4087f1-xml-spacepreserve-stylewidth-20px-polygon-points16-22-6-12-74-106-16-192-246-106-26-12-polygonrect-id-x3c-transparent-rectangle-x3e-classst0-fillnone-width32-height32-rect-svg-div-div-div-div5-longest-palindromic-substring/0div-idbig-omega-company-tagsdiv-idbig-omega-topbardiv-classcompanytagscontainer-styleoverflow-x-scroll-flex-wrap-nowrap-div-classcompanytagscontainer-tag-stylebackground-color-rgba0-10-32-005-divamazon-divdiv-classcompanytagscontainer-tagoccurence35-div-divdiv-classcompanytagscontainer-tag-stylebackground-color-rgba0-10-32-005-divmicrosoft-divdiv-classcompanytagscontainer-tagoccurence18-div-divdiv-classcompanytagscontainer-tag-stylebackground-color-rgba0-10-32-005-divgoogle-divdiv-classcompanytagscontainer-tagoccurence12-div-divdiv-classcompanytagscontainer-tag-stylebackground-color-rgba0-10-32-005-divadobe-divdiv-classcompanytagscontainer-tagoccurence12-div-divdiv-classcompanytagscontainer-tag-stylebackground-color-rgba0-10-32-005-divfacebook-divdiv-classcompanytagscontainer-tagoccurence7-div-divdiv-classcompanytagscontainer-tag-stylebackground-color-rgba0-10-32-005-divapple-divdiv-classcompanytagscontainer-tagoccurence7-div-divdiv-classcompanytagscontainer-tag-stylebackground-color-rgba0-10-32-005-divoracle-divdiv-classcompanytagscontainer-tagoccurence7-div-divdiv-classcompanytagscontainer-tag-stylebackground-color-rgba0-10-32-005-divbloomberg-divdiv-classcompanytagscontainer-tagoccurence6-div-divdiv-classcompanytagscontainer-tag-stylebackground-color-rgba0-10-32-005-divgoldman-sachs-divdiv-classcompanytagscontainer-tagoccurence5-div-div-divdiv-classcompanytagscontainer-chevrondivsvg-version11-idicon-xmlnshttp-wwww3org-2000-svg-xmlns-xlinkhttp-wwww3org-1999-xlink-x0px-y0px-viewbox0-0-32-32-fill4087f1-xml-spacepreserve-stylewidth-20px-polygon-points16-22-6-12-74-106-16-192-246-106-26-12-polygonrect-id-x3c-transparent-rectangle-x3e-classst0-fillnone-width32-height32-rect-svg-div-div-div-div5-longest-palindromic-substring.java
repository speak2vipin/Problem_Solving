class Solution {
    String ans = null;
    int longest = 0;
    public String longestPalindrome(String s) {
        int longest = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++) {
            palindrome(i-1, i+1, s, 1);
            palindrome(i, i+1, s, 0);
            
        }
        return ans;
    }
    
    void palindrome(int i, int j, String s, int len) {
        int N = s.length();
        while(i>-1 && j<N) {
            if(s.charAt(i)!=s.charAt(j)) {
                break;
            }
            i--;
            j++;
            len+=2;
        }
        if(len>longest) {
            ans = s.substring(i+1, j);
            longest = len;
        }
    }
}