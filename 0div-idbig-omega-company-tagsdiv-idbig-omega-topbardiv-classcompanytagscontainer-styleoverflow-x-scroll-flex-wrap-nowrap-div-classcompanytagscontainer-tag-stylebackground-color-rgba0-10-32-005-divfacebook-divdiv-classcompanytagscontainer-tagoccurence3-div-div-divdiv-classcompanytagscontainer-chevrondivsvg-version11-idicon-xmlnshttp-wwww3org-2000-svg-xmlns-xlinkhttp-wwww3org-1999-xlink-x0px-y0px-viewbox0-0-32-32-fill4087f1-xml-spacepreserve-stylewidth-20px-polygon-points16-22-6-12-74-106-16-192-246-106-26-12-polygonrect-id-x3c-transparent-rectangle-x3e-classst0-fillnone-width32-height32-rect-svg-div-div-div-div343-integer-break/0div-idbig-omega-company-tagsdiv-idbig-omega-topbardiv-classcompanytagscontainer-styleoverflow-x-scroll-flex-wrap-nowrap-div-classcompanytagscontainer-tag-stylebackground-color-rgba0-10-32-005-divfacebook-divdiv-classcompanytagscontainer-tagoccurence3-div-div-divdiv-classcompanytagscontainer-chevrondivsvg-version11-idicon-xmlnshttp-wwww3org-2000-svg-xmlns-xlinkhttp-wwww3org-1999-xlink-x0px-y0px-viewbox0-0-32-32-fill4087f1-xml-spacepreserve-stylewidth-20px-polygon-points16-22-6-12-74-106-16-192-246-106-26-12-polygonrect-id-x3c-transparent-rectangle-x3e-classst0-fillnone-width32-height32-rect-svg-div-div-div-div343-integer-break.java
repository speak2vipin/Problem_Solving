class Solution {
    Integer dp[] = null;
    public int integerBreak(int n) {
        if(n<=3) {
            return n-1;
        }
        dp = new Integer[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        return helper(n);
    }
    
    int helper(int n) {
        if(n<=3) {
            return dp[n];
        }
        if(dp[n]!=null) {
            return dp[n];
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<n; i++) {
            ans = Math.max(ans, i*helper(n-i));
        }
        return dp[n]=ans;
    }
}