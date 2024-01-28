class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // Calculate the prefix sum of every row
        for(int i=0; i<m; i++) {
            for(int j=1; j<n; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        // For every column
        for(int c1=0; c1<n; c1++) {
            for(int c2=c1; c2<n; c2++) {
                Map<Integer, Integer> dp = new HashMap<>();
                // for zero sum count would be 1;
                dp.put(0, 1);
                int sum = 0;
                
                for(int row=0; row<m; row++) {
                    sum += matrix[row][c2] - ((c1>0)?matrix[row][c1-1]:0);
                    // Take care of this c1-1 i.e. 
                    // u are looking for every subarray sum from c2
                    
                    count += dp.getOrDefault(sum-target,0);
                    dp.put(sum, dp.getOrDefault(sum,0)+1);
                }
            }
        }
        return count;
    }
}