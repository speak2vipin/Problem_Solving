class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int x = m;
        for(int[] array : matrix) {
            for(int i=0;i<m;i++) {
                if(array[i]==target) {
                    return true;
                } else {
                    if(array[i]>target) {
                        m = i;
                        break;
                    }
                    
                }
            }
        }
    return false;    
    }  
}