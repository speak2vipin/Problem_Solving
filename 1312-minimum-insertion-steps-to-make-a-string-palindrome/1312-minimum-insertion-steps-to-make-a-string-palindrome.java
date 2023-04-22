class Solution {
    // Logic :
    // Typical question of Longest common sibsequence (Common letters in two String. Here it is not manadatory to have words consequitively)
    // Find LCS in S and R (Reverse of S)
    // Subtract N (Length of String) - LCS
    // For calculating LCS
        // Simply Count on number of letters in both S AND R
        // If S.charAt(m-1) == S.charAt(n-1) => dp[m][n] = 1 + lcs(S,R,m-1, n-1)
        // else dp[m][n] = Math.max(lcs(S, R, m-1, n), lcs(S, R, m, n-1))
        // Return dp[m][n];
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