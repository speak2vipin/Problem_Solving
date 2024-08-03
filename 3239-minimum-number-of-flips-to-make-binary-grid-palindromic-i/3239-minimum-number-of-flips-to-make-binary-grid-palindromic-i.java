class Solution {
    public int minFlips(int[][] grid) {
        int flipRows = flipRow(grid);
        int flipCols = flipCol(grid);
        return Math.min(flipRows, flipCols);
    }
    
    int flipRow(int grid[][]) {  
        int count = 0;
        int n = grid[0].length;
        for(int g[] : grid) {
            int i = 0 ;
            while(i<n-i-1) {
                if(g[i]!=g[n-i-1])
                    count++;
                i++;
            }
        }
        return count;
    }
    
    int flipCol(int grid[][]) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int j=0; j<col; j++) {
            int i = 0;
            while(i<row-i-1) {
                if(grid[i][j]!=grid[row-i-1][j])
                    count++;
                i++;
            }
        }
        System.out.println("c : " + count);
        return count;
    }
    
}