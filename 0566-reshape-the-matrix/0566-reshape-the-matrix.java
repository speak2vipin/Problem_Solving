class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int re[][] = mat;
        int m = mat.length;
        int n = mat[0].length;
        
        if(r*c==m*n) {
            re = new int[r][c];
            int row = 0;
            int col = 0;
            int count = 1;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    //System.out.println(row + " " + col);
                    re[row][col++] = mat[i][j];
                    if(count%c==0) {
                        row++;
                        col = 0;
                    }
                    count++;
                }
            }
        }
        return re;
    }
}