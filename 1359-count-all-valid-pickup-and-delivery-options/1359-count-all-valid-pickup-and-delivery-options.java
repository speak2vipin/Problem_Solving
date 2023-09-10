class Solution {
    
    // Remember this solution 
    // https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/4024311/Beats-100-oror-C%2B%2B-oror-Java-oror-Python-oror-DP-Recursive-and-Iterative-oror-Commented-Code
    
    long mod = 1000_000_007;
    public int countOrders(int n) {
        if(n==1) {
            return 1;
        }
        long dp[] = new long[n+1];
        Arrays.fill(dp, -1);
        memoization(dp, n);
        return (int)(dp[n]%mod);
    }
    
    long memoization(long dp[], int n) {
        if(n==1) {
            return 1;
        }
        if(dp[n]!=-1) {
            return dp[n];
        }
        long validOptions = (memoization(dp, n-1)%mod) * ((2*n-1) * n)%mod;
        return dp[n] = validOptions; 
    }
}