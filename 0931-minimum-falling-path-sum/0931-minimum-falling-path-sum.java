class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
        
        int ans = Integer.MAX_VALUE;
        if(N==1) {
            return matrix[0][0];
        }
        
        for(int i = 1; i<N; i++) {
            for(int j = 0 ; j<N; j++) {
                int minTop = matrix[i-1][j];
                if(j>0) {
                    minTop = Math.min(minTop, matrix[i-1][j-1]);
                }
                if(j<N-1) {
                    minTop = Math.min(minTop, matrix[i-1][j+1]);
                }
                matrix[i][j] += minTop;
                if(i==N-1) {
                    ans = Math.min(ans, matrix[i][j]);
                }
            }
        }
        return ans;
        
    }
}