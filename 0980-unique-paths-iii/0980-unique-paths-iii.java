class Solution {
    int res = 0;
    int directions[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int start[] = null;
        int count_0 = 0;
        
        boolean vs[][] = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==0) {
                    count_0++;
                } else if(grid[i][j]==-1) {
                    vs[i][j] = true;
                } else if(grid[i][j]==1) {
                    start = new int[] {i, j};
                }
            }
        }
        helper(grid, start[0], start[1], vs, count_0);
        return res;
    }
    
    void helper(int grid[][], int i, int j,  boolean vs[][], int count_0) {
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || vs[i][j]) {
            return;
        }
        //System.out.println(i+ " " + j);
        if(grid[i][j]==0) {
            count_0--;
        } else if(grid[i][j]==2 && count_0==0) {
            res++;
            return;
        }
        
        vs[i][j] = true;
        for(int k=0; k<4; k++) {
            int di = i + directions[k][0];
            int dj = j + directions[k][1];
            helper(grid, di, dj, vs, count_0);
        }
        vs[i][j] = false;
    }
}