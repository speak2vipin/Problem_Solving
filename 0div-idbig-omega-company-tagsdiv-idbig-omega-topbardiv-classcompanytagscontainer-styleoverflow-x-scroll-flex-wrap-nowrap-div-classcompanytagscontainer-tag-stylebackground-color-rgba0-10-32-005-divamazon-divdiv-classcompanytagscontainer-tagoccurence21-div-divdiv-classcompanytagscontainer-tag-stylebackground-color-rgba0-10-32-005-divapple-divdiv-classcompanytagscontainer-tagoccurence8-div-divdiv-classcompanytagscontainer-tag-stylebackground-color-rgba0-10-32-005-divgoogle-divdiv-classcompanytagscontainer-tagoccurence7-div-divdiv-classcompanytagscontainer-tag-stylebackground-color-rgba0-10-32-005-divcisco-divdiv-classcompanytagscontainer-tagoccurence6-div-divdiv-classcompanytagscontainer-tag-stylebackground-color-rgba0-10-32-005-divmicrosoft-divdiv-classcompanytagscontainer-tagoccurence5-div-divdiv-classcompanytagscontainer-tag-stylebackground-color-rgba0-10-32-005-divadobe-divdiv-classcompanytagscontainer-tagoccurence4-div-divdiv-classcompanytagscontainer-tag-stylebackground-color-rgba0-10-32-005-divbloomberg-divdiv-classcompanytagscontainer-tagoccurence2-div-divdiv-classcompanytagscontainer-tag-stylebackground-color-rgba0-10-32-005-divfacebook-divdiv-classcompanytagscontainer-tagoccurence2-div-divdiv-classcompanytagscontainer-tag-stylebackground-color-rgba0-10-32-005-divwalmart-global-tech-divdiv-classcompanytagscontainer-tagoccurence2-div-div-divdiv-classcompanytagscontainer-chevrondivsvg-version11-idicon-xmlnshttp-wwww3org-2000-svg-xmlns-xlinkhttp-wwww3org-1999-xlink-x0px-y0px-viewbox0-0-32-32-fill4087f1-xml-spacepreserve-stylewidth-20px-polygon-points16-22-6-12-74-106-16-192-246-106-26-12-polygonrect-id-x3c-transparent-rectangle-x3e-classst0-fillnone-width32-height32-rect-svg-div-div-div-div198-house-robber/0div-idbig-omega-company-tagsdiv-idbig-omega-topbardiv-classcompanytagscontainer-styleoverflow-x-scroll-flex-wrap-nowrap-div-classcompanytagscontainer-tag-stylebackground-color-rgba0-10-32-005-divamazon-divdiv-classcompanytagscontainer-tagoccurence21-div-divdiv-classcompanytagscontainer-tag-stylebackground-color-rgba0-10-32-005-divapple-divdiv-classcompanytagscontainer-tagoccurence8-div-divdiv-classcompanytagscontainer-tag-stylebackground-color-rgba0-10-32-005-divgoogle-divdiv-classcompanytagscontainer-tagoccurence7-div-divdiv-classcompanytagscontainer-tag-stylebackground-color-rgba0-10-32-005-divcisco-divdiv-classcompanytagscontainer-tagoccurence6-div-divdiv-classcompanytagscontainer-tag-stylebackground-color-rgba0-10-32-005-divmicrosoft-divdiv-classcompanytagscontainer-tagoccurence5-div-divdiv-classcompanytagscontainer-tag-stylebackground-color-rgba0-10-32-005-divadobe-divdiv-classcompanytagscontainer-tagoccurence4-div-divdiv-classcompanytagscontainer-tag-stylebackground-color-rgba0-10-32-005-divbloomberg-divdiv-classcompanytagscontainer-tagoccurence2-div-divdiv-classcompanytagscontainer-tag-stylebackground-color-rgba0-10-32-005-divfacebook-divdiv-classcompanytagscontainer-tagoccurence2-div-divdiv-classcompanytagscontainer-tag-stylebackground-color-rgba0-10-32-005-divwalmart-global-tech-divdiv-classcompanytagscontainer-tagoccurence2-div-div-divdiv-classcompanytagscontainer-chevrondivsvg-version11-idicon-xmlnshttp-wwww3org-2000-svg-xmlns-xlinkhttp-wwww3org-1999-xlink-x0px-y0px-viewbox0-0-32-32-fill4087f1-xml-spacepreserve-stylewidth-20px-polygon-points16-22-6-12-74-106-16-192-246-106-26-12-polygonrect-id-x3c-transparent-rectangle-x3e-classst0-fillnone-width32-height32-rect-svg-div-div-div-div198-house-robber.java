class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
       // Arrays.fill(dp, -1);
        //return helper(nums, 0, dp);   
        
        for(int i=0; i<n; i++) {
            if(i-3>-1) {
               dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
            } else if(i-2>-1) {
              dp[i] = nums[i] + dp[i-2];   
            } else {
                dp[i] = nums[i]; 
            }
        }
        return Math.max(dp[n-2], dp[n-1]);
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