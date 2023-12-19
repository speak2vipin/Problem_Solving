class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int x[] = {-1, -1, 0, 1, 1,  1,  0, -1};
        int y[] = { 0,  1, 1, 1, 0, -1, -1, -1};
        int ans[][] = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int total = img[i][j];
                int factor = 1;
                for(int k=0; k<8; k++) {
                    if(i+x[k]>-1 && i+x[k]<m && j+y[k]>-1 && j+y[k]<n) {
                        total += img[i+x[k]][j+y[k]];
                        factor++;
                    }
                }
                ans[i][j] = total/factor;
            }
        }
        return ans;
    }
}