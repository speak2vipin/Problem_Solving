class Solution {
    
    // Remember this solution 
    // https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/4024311/Beats-100-oror-C%2B%2B-oror-Java-oror-Python-oror-DP-Recursive-and-Iterative-oror-Commented-Code
    
    // Lets assume we already have n-1 pairs
    // How many places would be required for nth pair
        // For 1st item of nth pair
        //  example n-1 --> 3 => total_items --> 6 => Total places for 4th pair
        //  _X_X_X_X_X_X_ -> All elements+1 i.e. 2*4 - 1
        // Total places for 1st element of 4th pair = 2*n - 1
        // Total places for 2nd element of 4th pair = 2*n
        // Total places = (2*n - 1) * (2*n)
        // Total places if 1st order comes before 2nd = (2*n-1)*(2*n)/2 = (2*n-1)*n
        // Same formula will be used for iterative calculations
    
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