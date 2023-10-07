class Solution {
    int dp[][][]= null;
    int n;
    int m;
    int mod = 1000000007;
    
    public int numOfArrays(int n, int m, int k) {
        this.n = n;
        this.m = m;
        dp = new int[n][m+1][k+1];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m+1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0, 0, k);
    }
    
    int helper(int i, int maxSoFar, int remain) {
        if(i==n) {
            if(remain==0) {
                return 1;
            }
            return 0;
        }
        if(remain<0) {
            return 0;
        }
        if(dp[i][maxSoFar][remain]!=-1) {
            return dp[i][maxSoFar][remain];
        }
        int ans = 0;
        for(int j=1; j<=maxSoFar; j++) {
            ans = (ans + helper(i+1, maxSoFar, remain))%mod;
        }
        for(int j=maxSoFar+1; j<=m; j++) {
            ans = (ans + helper(i+1, j, remain-1))%mod;    
        }
        dp[i][maxSoFar][remain] = ans;
        return ans;
    }
}