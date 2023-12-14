class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int diff[][] = new int[m][n];
        int oneRow[] = new int[m];
        int oneCol[] = new int[n];
                   
        for(int i=0; i<m; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) {
                    count++;
                }
            }
            oneRow[i] = count;
        }
        for(int j=0; j<n; j++) {
            int count = 0;
            for(int i=0; i<m; i++) {
                if(grid[i][j]==1) {
                    count++;
                }
            }
            oneCol[j] = count;
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                diff[i][j] = oneRow[i] + oneCol[j] - (m-oneRow[i]) - (n-oneCol[j]); 
            }
        }  
        return diff;
    }
}