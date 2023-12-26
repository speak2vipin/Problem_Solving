class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        long dp[] = new long[n+1];
        long mod = 1000_000_007;
        dp[n] = 1l;
        for(int i=n-1; i>-1; i--) {
            long ways = 0l;
            char letter = s.charAt(i);
            if(letter=='0') {
                dp[i] = 0l;
            } else {
                ways = dp[i+1];
                if(letter=='*') {
                    ways = (9 * dp[i+1])%mod;
                }
                if(i+1<n && s.substring(i, i+2).equals("**")) {
                    ways = (ways + 15* dp[i+2])%mod;
                }else if(i+1<n && s.charAt(i+1)=='*') {
                    if(s.charAt(i)=='1') {
                        ways = (ways + 9* dp[i+2])%mod;
                    } else if(s.charAt(i)=='2') {
                        ways = (ways + 6* dp[i+2])%mod;
                    }
                } else if(i+1<n && s.charAt(i)=='*') {
                    if((s.charAt(i+1)-'0')<7) {
                        ways = (ways + 2*dp[i+2])%mod;
                    } else if((s.charAt(i+1)-'0')>6) {
                        ways = (ways + dp[i+2])%mod;
                    } 
                } else if(i+1<n && Integer.parseInt(s.substring(i, i+2))<=26) {
                    ways = (ways + dp[i+2])%mod;
                }
            }
            dp[i] = ways;
        }
        return (int)dp[0];
        
    }
}