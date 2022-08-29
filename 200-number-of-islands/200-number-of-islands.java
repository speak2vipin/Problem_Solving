class Solution {
    public int numIslands(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int count = 0;
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(grid[i][j]=='1') {
                    // Cover all the existing 1, comes in it's premise
                    // change '1' to '0'
                    coverIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    void coverIsland(char[][]grid, int i, int j) {
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]!='1') {
            return;
        }
        grid[i][j] = '0';
        coverIsland(grid, i+1, j);
        coverIsland(grid, i-1, j);
        coverIsland(grid, i, j+1);
        coverIsland(grid, i, j-1);
    }
}