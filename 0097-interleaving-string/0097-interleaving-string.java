class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l = s1.length();
        int m = s2.length();
        int n = s3.length();
        if(l+m!=n) {
            return false;
        }
        boolean dp[][] = new boolean[l+1][m+1];

        dp[l][m] = true;
               
        for(int i=l; i>-1; i--) {
            for(int j=m; j>-1; j--) {
                if(i<l && s1.charAt(i)==s3.charAt(i+j) && dp[i+1][j]) {
                    dp[i][j] = true;
                }
                if(j<m && s2.charAt(j)==s3.charAt(i+j) && dp[i][j+1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
        
    }
}