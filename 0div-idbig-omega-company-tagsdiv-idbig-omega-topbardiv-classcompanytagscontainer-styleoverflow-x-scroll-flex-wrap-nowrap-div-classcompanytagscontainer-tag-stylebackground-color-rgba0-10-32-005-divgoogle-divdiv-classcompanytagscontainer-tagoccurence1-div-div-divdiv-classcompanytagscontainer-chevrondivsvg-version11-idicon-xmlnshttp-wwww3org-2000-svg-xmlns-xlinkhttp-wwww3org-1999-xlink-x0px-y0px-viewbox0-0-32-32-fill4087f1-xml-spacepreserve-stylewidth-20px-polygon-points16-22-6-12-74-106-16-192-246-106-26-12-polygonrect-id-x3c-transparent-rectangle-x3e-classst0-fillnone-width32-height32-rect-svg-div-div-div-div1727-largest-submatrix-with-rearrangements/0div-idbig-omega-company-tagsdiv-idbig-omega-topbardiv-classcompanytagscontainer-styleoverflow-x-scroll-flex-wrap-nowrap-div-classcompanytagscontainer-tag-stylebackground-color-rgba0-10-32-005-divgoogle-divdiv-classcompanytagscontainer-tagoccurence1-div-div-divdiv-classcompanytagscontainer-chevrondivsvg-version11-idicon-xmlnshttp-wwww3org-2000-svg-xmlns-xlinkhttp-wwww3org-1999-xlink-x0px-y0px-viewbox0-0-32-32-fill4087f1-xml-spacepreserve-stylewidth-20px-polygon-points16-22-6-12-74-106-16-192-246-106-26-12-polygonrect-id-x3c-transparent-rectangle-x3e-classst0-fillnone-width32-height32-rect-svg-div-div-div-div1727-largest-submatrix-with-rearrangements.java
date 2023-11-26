class Solution {
    public int largestSubmatrix(int[][] matrix) {
       
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int prevRow[] = new int[m];
        for(int i=0; i<n; i++) {
            int currRow[] = matrix[i].clone();
            for(int j=0; j<m; j++) {
	            if(i>0 && matrix[i][j]==1) {
	                currRow[j] = matrix[i][j] + prevRow[j];
	            } 
            }  
            int sortedRow[] = currRow.clone();
            Arrays.sort(sortedRow);
            
            for(int k=m-1; k>-1; k--) {
                ans = Math.max(ans, sortedRow[k] * (m-k));
            }
            prevRow = currRow;
        }
        return ans;           
             
    }
}