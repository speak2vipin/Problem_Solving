class Solution {
    public int diagonalSum(int[][] mat) {
        int N = mat.length;
        int sum = 0;
        int tempSum = 0;
        for(int i=0, j=N-1; i<N && j>-1; i++, j--) {
            if(i!=j) {
                tempSum = mat[i][i] + mat[i][j];
            }
            else {
                tempSum = mat[i][i];
            }
            sum += tempSum;
        }
        return sum;
    }
}