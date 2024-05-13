class Solution {
    public int matrixScore(int[][] grid) {
        // Focus on the most significant bit to make it 1
        // then focus on every column and check if we have more 1's then 0's or not
        // if yes then just take it in sum
        // else take m-one to score.
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

