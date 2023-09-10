class Solution {
    
    // Remember this solution 
    // https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/4024311/Beats-100-oror-C%2B%2B-oror-Java-oror-Python-oror-DP-Recursive-and-Iterative-oror-Commented-Code
    
    long mod = 1000_000_007;
    
    public int countOrders(int n) {
        long dp[] = new long[n+1];
        Arrays.fill(dp, -1);
        return memoizationBottomToUp(dp, n);
    }
    
    int memoizationBottomToUp(long dp[], int n) {
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] * ((2*i-1)*i)%mod;
        }
        return (int)dp[n];
    }
    public int countOrdersTopToDown(int n) {
        if(n==1) {
            return 1;
        }
        long dp[] = new long[n+1];
        Arrays.fill(dp, -1);
        memoizationTopToDown(dp, n);
        return (int)(dp[n]%mod);
    }
    
    long memoizationTopToDown(long dp[], int n) {
        if(n==1) {
            return 1;
        }
        if(dp[n]!=-1) {
            return dp[n];
        }
        long validOptions = (memoizationTopToDown(dp, n-1)%mod) * ((2*n-1) * n)%mod;
        return dp[n] = validOptions; 
    }
}