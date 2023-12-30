class NumMatrix {
   
    int prefix[][] = null;
    int r = -1;
    int c = -1;
    public NumMatrix(int[][] matrix) {
        r = matrix.length;
        c = matrix[0].length;
        prefix = new int[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(j==0) {
                    prefix[i][j] = matrix[i][j];
                } else {
                    prefix[i][j] = prefix[i][j-1] + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i<row2+1; i++) {
            sum += prefix[i][c-1];
            if(col1==0) {
                
            } else {
                sum -= prefix[i][col1-1];
            }
            if(col2==c-1) {
                
            } else {
                sum -= prefix[i][c-1] - prefix[i][col2];
            }
        }
        return sum;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */