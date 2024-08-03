class Solution {
    public int minFlips(int[][] grid) {
        int flipRows = 0;
        for(int g[] : grid) {
            flipRows += flipRow(g);
        }
        System.out.println("f : " + flipRows);
        int flipCols = flipCol(grid);
        return Math.min(flipRows, flipCols);
    }
    
    int flipRow(int grid[]) {
        int i = 0 ;
        int count = 0;
        int n = grid.length-1;
        while(i<n-i) {
            if(grid[i]!=grid[n-i])
                count++;
            i++;
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