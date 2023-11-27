class Solution {
    int memo[][];
    int n;
    int mod = 1000_000_007;
    int jumps[][] = {{4,6}, 
                        {6,8}, 
                        {7,9},
                        {4,8},
                        {3,9,0},
                        {}, 
                        {1,7,0}, 
                        {2,6}, 
                        {1,3}, 
                        {2,4}};
    
    int dp(int remain, int square) {
        if(remain==0) {
            return 1;
        }
        if(memo[remain][square]!=0) {
            return memo[remain][square];
        }
        int ans = 0;
        for(int nextSquare : jumps[square]) {
            ans = (ans + dp(remain-1, nextSquare))%mod;
        }
        memo[remain][square] = ans;
        return ans;
    }
    public int knightDialer(int n) {
        this.n = n;
        memo = new int[n+1][10];
        int ans = 0;
        for(int square=0; square<10; square++) {
            ans = (ans + dp(n-1, square))%mod;
        }
        return ans;
    }
}