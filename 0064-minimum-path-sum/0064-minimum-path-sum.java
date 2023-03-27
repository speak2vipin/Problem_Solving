class Solution {
   /* int N = 0;
	int M = 0;
	int ans = Integer.MAX_VALUE;
	public int minPathSum(int[][] grid) {
	        N = grid.length;
	        M = grid[0].length;
	        boolean [][]vst = new boolean[N][M];
	        dfs(0, 0, grid, vst, 0);
	        return ans;
	    }
	    
	    void dfs(int x, int y, int[][] grid, boolean vst[][], int wt) {
	        
	        if(!vst[x][y]) {
	            if(x==N-1 && y==M-1) {
	                wt += grid[x][y];
	                ans = Math.min(ans, wt);
	                return;
	            }
	            vst[x][y] = true;
	            int dx[] = {1,0};
	            int dy[] = {0,1};
	            wt += grid[x][y];
	            for(int i=0; i<2; i++) {
	                if(isTravel(x+dx[i], y+dy[i])) {
	                    dfs(x+dx[i], y+dy[i], grid, vst, wt);
	                }
	            }
	            vst[x][y] = false;
	            wt -= grid[x][y];
	        }
	    }
	    
	    boolean isTravel(int x, int y) {
	        return (x<N && x>-1) && (y<M && y>-1);    
	    }*/
    
   /* public int minPathSum(int[][] grid) {
	        int N = grid.length;
	        int M = grid[0].length;
	        int dp[][] = new int[N][M];
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(i==0 && j==0) {
                        dp[i][j] = grid[i][j];
                    } else if(i==0) {
                        dp[i][j] = grid[i][j]+dp[i][j-1];
                    } else if(j==0) {
                        dp[i][j] = grid[i][j]+dp[i-1][j];   
                    } else {
                        dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }
        return dp[N-1][M-1];
    }*/
    
    public int minPathSum(int[][] grid) {
	        int N = grid.length;
	        int M = grid[0].length;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(i==0 && j==0) {
                        grid[i][j] = grid[i][j];
                    } else if(i==0) {
                        grid[i][j] = grid[i][j]+grid[i][j-1];
                    } else if(j==0) {
                        grid[i][j] = grid[i][j]+grid[i-1][j];   
                    } else {
                        grid[i][j] = grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j]);
                    }
                }
            }
        return grid[N-1][M-1];
    }
}