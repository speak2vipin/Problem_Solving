class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int temp;
        // Find trnaspose of Matrix i.e. Row to Column and Column to Row
        for(int i=0;i<N;i++) {
            for(int j=i;j<N;j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<N;i++) {
            // Reverse every Row
            int j=0; int k = N-1;
            while(j<k) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    } 
}