class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean res = false;
        int index = -1;
        for(int i=0; i<n; i++) {
            if(matrix[i][0]<=target && target<=matrix[i][m-1]) {
                index = i;
                break;
            }
        }
        if(index != -1) {
            res = binarySearch(matrix[index], target);
        }
        return res;
    }
    
    boolean binarySearch(int searchSpace[], int target) {
        int st = 0;
        int en = searchSpace.length-1;
        while(st<=en) {
            int mid = en - ((en - st)/2);
            if(searchSpace[mid]==target) {
                return true;
            }
            if(searchSpace[mid]<target) {
                st = mid+1;
            } else {
                en = mid-1;
            }
        }
        return false;
    }
}