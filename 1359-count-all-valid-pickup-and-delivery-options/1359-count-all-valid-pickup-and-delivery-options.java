class Solution {
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