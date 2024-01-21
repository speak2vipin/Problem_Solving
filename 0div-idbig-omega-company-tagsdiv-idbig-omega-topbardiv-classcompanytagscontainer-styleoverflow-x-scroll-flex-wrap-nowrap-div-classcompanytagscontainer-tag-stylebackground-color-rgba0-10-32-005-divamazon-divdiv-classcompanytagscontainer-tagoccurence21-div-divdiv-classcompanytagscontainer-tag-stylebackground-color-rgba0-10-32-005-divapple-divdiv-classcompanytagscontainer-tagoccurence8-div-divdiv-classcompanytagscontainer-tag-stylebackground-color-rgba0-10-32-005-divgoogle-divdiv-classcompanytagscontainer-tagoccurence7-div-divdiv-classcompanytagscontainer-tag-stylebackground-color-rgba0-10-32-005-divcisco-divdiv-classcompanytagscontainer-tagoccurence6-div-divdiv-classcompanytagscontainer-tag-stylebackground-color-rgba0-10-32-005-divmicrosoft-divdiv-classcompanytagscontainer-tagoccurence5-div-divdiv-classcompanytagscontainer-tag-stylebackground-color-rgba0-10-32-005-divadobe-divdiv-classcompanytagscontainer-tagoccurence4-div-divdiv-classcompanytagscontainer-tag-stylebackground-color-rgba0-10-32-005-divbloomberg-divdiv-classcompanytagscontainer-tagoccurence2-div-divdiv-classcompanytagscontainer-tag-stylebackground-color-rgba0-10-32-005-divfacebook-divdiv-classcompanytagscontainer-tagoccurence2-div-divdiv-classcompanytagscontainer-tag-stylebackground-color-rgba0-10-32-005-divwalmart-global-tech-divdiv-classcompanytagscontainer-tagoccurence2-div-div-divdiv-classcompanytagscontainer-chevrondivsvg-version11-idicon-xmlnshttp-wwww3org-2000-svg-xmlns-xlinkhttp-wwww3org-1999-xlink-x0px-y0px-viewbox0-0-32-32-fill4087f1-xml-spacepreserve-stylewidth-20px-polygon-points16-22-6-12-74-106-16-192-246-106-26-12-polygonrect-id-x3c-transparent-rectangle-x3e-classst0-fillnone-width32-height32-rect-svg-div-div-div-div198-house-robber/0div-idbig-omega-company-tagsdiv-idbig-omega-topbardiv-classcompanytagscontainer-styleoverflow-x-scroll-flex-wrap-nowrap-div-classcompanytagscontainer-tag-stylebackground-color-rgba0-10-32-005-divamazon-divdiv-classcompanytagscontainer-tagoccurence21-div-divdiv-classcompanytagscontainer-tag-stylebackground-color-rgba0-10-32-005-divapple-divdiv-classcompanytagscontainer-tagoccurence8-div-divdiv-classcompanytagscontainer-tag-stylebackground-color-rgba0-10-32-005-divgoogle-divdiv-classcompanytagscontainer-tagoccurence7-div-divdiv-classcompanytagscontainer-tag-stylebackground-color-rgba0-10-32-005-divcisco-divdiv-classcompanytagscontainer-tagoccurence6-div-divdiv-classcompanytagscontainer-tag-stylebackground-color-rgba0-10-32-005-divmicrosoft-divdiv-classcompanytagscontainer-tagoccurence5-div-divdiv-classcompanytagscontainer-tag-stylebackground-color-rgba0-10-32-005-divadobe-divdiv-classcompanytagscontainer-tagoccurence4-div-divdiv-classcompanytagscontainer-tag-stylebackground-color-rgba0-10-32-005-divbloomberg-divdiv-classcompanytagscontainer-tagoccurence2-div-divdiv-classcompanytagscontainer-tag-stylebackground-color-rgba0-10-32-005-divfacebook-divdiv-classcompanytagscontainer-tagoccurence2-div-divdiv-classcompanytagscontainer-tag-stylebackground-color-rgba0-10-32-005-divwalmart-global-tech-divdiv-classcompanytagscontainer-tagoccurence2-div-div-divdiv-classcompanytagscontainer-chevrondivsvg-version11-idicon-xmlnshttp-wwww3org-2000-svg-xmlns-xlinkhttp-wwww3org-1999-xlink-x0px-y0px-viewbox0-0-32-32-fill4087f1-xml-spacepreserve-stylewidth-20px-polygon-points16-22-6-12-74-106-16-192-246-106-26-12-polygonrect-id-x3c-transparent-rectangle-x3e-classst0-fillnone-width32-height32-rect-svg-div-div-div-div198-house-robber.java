class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);   
    }
    
    int helper(int nums[], int i, int dp[]) {
        if(i>=nums.length) {
            return 0;
        }
        if(dp[i]!=-1) {
            return dp[i];
        }
        int max = Math.max(nums[i] + helper(nums, i+2, dp), helper(nums, i+1, dp));
        return dp[i] = max;
        
    }
}