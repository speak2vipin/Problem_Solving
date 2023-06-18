class Solution {
    int dp[][];
    int dx[] = {-1, 0, 1,  0};
    int dy[] = { 0, 1, 0, -1};
    int mod = 1000000007;
    public int countPaths(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        int answer = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                answer = (answer + dfs(grid, i, j))%mod;
            }
        }
        return answer;
    }
    
    int dfs(int[][]grid, int i, int j) {
        if(dp[i][j]!=0) {
            return dp[i][j];
        }
        int answer = 1;
        
        for(int k=0; k<4; k++) {
            int prevI = i+dx[k];
            int prevJ = j+dy[k];
            if(prevI>=0 && prevI < grid.length
              && prevJ>=0 && prevJ<grid[0].length && grid[prevI][prevJ]<grid[i][j]) {
                answer += dfs(grid, prevI, prevJ);
                answer = answer%mod;
            }
        }
        dp[i][j] = answer;
        return answer;
    }
}