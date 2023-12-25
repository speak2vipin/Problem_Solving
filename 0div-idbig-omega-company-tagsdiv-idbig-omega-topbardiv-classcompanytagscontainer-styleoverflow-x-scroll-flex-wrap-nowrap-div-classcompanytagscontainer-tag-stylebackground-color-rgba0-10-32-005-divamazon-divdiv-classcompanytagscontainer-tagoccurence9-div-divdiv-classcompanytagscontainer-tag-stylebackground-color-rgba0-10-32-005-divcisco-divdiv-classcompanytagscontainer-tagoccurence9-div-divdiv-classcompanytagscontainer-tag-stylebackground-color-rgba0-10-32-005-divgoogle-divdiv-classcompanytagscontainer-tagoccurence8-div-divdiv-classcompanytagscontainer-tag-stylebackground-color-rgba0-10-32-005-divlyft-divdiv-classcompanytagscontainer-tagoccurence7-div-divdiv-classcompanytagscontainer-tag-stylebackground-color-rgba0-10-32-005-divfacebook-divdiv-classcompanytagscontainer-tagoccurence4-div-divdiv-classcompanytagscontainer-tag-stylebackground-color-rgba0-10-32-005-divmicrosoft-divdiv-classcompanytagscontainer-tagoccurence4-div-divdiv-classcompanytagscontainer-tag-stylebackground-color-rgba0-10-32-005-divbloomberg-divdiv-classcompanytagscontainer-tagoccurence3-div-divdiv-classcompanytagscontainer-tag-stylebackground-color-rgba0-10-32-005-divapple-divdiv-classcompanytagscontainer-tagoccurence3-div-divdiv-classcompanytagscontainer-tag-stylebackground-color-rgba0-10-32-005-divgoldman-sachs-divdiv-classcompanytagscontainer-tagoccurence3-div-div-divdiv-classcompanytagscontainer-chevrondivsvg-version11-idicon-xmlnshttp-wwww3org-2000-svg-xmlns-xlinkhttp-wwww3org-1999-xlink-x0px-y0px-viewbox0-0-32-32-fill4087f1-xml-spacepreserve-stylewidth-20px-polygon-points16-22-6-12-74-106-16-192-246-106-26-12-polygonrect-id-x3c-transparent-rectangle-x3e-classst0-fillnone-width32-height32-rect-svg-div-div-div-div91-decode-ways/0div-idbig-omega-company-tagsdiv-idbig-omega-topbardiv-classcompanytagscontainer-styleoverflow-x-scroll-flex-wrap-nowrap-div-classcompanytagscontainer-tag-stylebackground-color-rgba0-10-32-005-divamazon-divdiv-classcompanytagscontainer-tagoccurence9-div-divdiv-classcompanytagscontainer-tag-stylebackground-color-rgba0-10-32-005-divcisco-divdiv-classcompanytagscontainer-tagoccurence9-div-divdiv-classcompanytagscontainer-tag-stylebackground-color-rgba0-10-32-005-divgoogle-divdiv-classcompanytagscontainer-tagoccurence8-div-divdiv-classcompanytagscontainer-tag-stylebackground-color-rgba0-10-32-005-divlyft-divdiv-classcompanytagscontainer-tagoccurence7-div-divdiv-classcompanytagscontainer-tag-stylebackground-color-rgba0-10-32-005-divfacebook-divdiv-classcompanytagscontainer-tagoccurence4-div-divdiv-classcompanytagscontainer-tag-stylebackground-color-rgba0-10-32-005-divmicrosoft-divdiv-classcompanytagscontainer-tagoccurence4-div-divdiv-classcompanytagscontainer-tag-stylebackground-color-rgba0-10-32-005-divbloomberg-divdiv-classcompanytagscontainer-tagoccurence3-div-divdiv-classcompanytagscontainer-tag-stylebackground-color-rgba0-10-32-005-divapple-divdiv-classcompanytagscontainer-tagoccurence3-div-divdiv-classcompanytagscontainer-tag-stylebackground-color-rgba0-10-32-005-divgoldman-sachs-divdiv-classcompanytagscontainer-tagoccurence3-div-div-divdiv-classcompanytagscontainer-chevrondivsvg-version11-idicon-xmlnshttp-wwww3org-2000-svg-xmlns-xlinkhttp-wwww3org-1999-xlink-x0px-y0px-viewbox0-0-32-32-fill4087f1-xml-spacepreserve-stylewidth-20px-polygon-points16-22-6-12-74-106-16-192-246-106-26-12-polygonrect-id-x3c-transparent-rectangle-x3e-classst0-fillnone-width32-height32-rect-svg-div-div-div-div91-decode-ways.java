class Solution {
    int dp[] = null;
    
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        memo(s, 0);
        return dp[0];
    }
    
    int memo(String s, int i) {
       if(i>=s.length()) {
           return 1;
       }
        if(s.charAt(i)=='0') {
            return 0;
        }
        if(dp[i]>0) {
            return dp[i];
        }
        int ways = memo(s, i+1);
        if(i+1<s.length() && Integer.parseInt(s.substring(i, i+2))<=26) {
            ways += memo(s, i+2);
        }
        return dp[i] = ways;
    }
}