class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = 1000_000_007;
        int dp[][] = new int[m][n];
        dp[startRow][startColumn] = 1;
        int count = 0; 
        
        for(int k=0; k<maxMove; k++)
        {
            int temp[][] = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++) {
                   /* if(i==m-1) {
                        count = (count + dp[i][j])%mod; 
                    }
                    if (j==n-1) {
                        count = (count + dp[i][j])%mod; 
                    }
                    if(i==0){
                        count = (count + dp[i][j])%mod;
                    }
                    if(j==0) {
                        count = (count + dp[i][j])%mod;
                    }*/
                    
                    
                    if (i == m - 1) count = (count + dp[i][j]) % mod;
                    if (j == n - 1) count = (count + dp[i][j]) % mod;
                    if (i == 0) count = (count + dp[i][j]) % mod;
                    if (j == 0) count = (count + dp[i][j]) % mod;
                    temp[i][j] = 
                        ((
                            (i>0 ? dp[i-1][j]:0) + 
                            (i+1<m ? dp[i+1][j] : 0))%mod
                    + (
                        (j>0? dp[i][j-1]:0) + 
                        (j+1<n ? dp[i][j+1] : 0))%mod)%mod;
          
                }
            }
           dp = temp;
                
        }
        
        return count;
    }        
}