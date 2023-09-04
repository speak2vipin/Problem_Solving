class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return helper(dp, 0, 0, m, n);
        /*
        for(int i=0; i<m; i++) {
            dp[i][0] = 1;
        }
        for(int j=0; j<n; j++) {
            dp[0][j] = 1;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
        */
    }
    
    public int helper(int dp[][], int i, int j, int m, int n) {
        if(i==m-1 && j==n-1) {
            return dp[i][j] = 1;
        }
        
        if(dp[i][j]!=-1) {
            return dp[i][j];
        }
        
        int maxI = 0;
        if(i<m-1) {
            maxI = helper(dp, i+1, j, m, n);  
        }
        
        int maxJ = 0;
        if(j<n-1) {
            maxJ = helper(dp, i, j+1, m, n);  
        }
        return dp[i][j] = maxI + maxJ;
    }
}