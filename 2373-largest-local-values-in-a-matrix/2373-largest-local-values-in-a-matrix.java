class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int res[][] = new int[n-2][n-2];
        for(int i=0; i<n-2; i++) {
            for(int j=0; j<n-2; j++) {
                res[i][j] = findMax(grid, i, j, n);
            }
        }
        return res;
    }
    
    int findMax(int grid[][], int i, int j, int n) {
        int max = grid[i][j];
        for(int x=i; x<i+3; x++) {
            for(int y=j; y<j+3; y++) {
                max = Math.max(max, grid[x][y]);
            }
        }
        return max;
    }
}