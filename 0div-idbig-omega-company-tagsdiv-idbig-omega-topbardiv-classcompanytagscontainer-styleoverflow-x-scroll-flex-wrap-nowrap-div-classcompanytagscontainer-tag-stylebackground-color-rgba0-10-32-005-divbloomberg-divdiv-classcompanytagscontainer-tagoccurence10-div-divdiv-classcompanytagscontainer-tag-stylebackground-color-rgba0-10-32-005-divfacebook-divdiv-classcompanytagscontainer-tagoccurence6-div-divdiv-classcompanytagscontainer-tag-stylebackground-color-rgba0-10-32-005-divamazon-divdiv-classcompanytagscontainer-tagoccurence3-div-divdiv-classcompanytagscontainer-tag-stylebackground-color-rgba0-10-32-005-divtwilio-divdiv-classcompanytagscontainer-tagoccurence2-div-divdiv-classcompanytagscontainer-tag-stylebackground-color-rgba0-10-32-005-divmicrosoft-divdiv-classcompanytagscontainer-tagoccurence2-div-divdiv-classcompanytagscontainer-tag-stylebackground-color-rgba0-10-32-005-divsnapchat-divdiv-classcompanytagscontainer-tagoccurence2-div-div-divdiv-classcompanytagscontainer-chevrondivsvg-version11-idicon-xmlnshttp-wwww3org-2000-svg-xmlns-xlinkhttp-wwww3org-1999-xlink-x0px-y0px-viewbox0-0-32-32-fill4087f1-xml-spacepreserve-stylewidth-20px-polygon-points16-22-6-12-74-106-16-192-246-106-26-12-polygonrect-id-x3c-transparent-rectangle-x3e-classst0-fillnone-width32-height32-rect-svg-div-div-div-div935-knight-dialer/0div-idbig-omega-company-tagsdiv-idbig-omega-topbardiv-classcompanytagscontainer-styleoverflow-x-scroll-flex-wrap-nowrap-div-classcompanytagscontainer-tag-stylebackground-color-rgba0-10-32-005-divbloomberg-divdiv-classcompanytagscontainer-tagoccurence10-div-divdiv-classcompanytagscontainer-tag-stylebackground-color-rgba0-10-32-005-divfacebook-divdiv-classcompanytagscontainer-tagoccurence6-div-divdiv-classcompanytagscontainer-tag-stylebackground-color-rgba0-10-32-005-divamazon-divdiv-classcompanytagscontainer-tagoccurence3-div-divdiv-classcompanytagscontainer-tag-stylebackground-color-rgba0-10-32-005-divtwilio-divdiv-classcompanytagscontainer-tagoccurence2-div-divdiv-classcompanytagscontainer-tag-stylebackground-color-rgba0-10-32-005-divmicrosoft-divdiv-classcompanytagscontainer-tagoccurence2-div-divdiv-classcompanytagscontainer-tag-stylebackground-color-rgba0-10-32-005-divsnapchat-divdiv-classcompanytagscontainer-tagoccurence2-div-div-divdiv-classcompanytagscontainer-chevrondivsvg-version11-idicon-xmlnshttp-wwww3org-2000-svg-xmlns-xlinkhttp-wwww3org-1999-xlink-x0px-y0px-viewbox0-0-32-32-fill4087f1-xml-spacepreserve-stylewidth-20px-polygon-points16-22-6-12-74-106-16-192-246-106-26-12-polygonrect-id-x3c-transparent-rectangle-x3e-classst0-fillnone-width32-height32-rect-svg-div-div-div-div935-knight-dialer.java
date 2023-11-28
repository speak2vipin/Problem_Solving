class Solution {
    int jump[][]={{4,6},
                  {6,8},
                  {7,9},
                  {4,8},
                  {0,3,9},
                  {},
                  {1,7,0},
                  {2,6},
                  {1,3},
                  {4,2}};
    
    int memo[][] = null;
    int n = 0;
    int mod = 1000_000_007;
    
    public int knightDialer(int n) {
        memo = new int[n+1][10];
        this.n = n;
        int ans = 0;
        for(int i=0; i<10; i++) {
            ans = (ans + dp(n-1, i))%mod;
        }
        return ans;
    }
    
    int dp(int remain, int square) {
        if(remain==0) {
            return 1;
        }
        if(memo[remain][square]!=0) {
            return memo[remain][square];
        }
        int ans = 0;
        for(int i=0; i<jump[square].length; i++) {
            ans = (ans + dp(remain-1, jump[square][i]))%mod;
        }
        
        return memo[remain][square]=ans;
    }
}