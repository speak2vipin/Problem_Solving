class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int count = 1;
        while(true) {
            for(int j=left; j<=right; j++) {
                ans[top][j] = count++;
            }
            top++;
            if(top>n-1 || top>bottom) break;
            
            
            for(int i=top; i<=bottom; i++) {
                ans[i][right] = count++;
            }
            right--;
            if(right<0 || left>right) break;
            
            
            for(int j=right; j>=left; j--) {
                ans[bottom][j] = count++;
            }
            bottom--;
            if(bottom<0 || bottom<top) break;
            
            
            for(int i=bottom; i>=top; i--) {
                ans[i][left] = count++;
            }
            left++;
            if(left>n-1 || left>right) break;
            
        }
        return ans;
    }
}