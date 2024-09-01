class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int convert[][] = new int[0][0];
        
        if(m*n == original.length) {
            convert = new int[m][n];
            int k = 0;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    convert[i][j] = original[k++];
                }
            }
        }
        return convert;
    }
}