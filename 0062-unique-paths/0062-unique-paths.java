class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
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
    }
    
   /* public int helper(int dp[][], int m, int n) {
        if(m==M-1 && n==N-1) {
            dp[m][n] = dp[m-1][n];
            return 0;
        }
        if(m==M-1) {
            
        }
        if(m==N-1) {
            
        }
        
    }*/
}