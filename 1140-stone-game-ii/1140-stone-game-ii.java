class Solution {
    
    public int stoneGameII(int[] piles) {
        int N = piles.length;
        int dp[][][] = new int[2][N+1][N+1];
        for(int i=0; i<2; i++) {
            for(int j=0; j<N+1; j++) {
                for(int k=0; k<N+1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return f(piles, dp, 0, 0, 1);
    }
    
    private int f(int piles[], int[][][]dp, int p, int i, int m) {
        
        if (i == piles.length) {
            return 0;
        }
        if(dp[p][i][m]!=-1) {
            return dp[p][i][m];
        }
        
        int res = p == 1 ? 1000000 : -1; 
        int s = 0;
        for (int x = 1; x <= Math.min(2 * m, piles.length - i); x++) {
            s += piles[i + x - 1];
            if (p == 0) {
                res = Math.max(res, s + f(piles, dp, 1, i + x, Math.max(m, x)));
            }
            else {
                res = Math.min(res, f(piles, dp, 0, i + x, Math.max(m, x)));
            }
        }
        return dp[p][i][m] = res;
    }  
}