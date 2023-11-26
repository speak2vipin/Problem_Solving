class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i>0 && matrix[i][j]==1) {
                    matrix[i][j] = matrix[i][j] + matrix[i-1][j];
                }
            }
        
            int currRow[] = matrix[i].clone();
            Arrays.sort(currRow);
            
            for(int k=m-1; k>-1; k--) {
                ans = Math.max(ans, currRow[k] * (m-k));
            }
        }
        return ans;           
    }
}