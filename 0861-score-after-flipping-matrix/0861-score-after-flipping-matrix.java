class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int score = 0;
        for(int i=0; i<m; i++) {
            if(grid[i][0]==0) {
                for(int j=0; j<n; j++) {
                    grid[i][j] = 1-grid[i][j];
                }
            }
        }
        score += (1<<n-1)*m;
        
        for(int j=1; j<n; j++) {
            int one = 0;
            for(int i=0; i<m; i++) {
                if(grid[i][j]==1) {
                    one++;
                }
            }
            if(one<m-one) {
                score += (1<<n-1-j)*(m-one);  
            } else {
                score += (1<<n-1-j)*(one);
            }
        }
        return score;
        
    }
}

