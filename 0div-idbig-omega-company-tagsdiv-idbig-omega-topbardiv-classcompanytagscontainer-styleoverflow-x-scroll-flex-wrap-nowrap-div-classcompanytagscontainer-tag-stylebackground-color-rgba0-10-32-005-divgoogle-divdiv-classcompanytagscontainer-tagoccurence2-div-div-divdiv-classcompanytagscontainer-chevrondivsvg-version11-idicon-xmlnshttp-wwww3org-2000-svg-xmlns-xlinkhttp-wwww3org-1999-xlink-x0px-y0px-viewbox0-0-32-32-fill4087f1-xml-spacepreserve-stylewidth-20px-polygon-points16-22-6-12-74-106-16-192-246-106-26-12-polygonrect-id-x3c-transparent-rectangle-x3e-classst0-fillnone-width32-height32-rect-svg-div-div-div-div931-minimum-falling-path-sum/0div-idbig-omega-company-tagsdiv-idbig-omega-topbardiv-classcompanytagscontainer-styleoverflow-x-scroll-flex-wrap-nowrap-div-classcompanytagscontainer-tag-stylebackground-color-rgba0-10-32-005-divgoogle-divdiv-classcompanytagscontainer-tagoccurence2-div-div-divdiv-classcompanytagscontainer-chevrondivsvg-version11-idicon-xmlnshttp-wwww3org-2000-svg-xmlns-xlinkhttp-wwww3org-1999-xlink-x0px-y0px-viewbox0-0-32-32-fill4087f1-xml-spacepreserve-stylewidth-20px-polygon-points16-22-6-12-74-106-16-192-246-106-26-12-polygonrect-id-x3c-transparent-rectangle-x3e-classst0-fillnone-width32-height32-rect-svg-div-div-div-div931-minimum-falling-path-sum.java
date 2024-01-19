class Solution {
    int ans = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        int x = matrix.length;
        
        if(x==1) {
            return matrix[0][0];
        }
        
        for(int i=1; i<x; i++) {
            for(int j=0; j<x; j++) {
                int min = matrix[i-1][j];
                if(j-1>-1) {
                    min = Math.min(min, matrix[i-1][j-1]);
                }
                if(j+1<x) {
                    min = Math.min(min, matrix[i-1][j+1]);
                }
                matrix[i][j] += min;
                if(i==x-1) {
                    ans = Math.min(ans, matrix[i][j]);
                }
            }
        }
        return ans;
    }
    
    
}