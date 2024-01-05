class Solution {
    int dp[] = null;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    
   
}