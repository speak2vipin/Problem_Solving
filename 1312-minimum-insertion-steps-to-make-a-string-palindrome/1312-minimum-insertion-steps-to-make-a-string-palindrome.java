class Solution {
    int dp[][] = null;
    
    public int minInsertions(String s) {
        int N = s.length();
        dp = new int[N+1][N+1];
        for(int i=0; i<N+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        String r = new StringBuilder(s).reverse().toString();
        int lcs = lcs(s, r, N, N);
        return N - lcs;
    }
    
    int lcs (String s, String r, int m, int n) {
        
        if(m==0 || n==0) {
            return 0;
        }
        if(dp[m][n]!=-1) {
            return dp[m][n];
        }
        if(s.charAt(m-1)==r.charAt(n-1)) {
            return dp[m][n] = 1 + lcs(s, r, m-1, n-1);
        }
        dp[m][n] = Math.max(lcs(s, r, m-1, n), lcs(s, r, m, n-1));
        return dp[m][n];
    }
}