class Solution {
    int dp[] = null;
    
    public int numDecodings(String s) {
        //int n = s.length();
        //dp = new int[n];
        //memo(s, 0);
        //return dp[0];
        return topToBottom(s);
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
    
    int topToBottom(String s) {
        int n = s.length();
        
        dp = new int[n+1];
        dp[n] = 1; // Empty string has one way to decode it.
        for(int i=n-1; i>-1; i--) {
            if(s.charAt(i)=='0') {
                dp[i] = 0;
            } else {
                int ways = dp[i+1];
                if(i+1<n && Integer.parseInt(s.substring(i, i+2))<=26) {
                    ways += dp[i+2];
                }
                dp[i] = ways;
            }
        }
        return dp[0];
    }
}