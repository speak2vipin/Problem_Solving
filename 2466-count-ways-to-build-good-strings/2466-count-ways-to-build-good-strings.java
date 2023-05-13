class Solution {
    
    int dp[] = null;
    int mod = 1000_000_007;
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        int ans = 0;
        
        for(int end =low; end<=high; end++) {
            ans = (ans + helper(zero, one, end))%mod;
        }
        return ans;
    }
    
    int helper(int zero, int one, int end) {
       
        if(dp[end]!=-1) {
            return dp[end];
        }
        int count = 0;
        if(end-one>=0) {
            count = (count + helper(zero, one, end-one))%mod;
        }
        if(end-zero>=0) {
            count = (count + helper(zero, one, end-zero))%mod;
        }
        return dp[end] = count;
    }
}