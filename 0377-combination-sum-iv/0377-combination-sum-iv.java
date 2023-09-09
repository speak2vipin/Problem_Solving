class Solution {
    Integer dp[] = null;
    
    public int combinationSum4(int[] nums, int target) {
        Integer dp[] = new Integer[target + 1];
		helper(dp, 0, target, nums);
		return dp[0]==null?0:dp[0];
	}

	int helper(Integer dp[], int sum, int target, int nums[]) {
        if(sum>target) {
            return 0;
        }
        if(sum==target) {
        	return 1;
        }
        if(dp[sum]!=null) {
            return dp[sum];
        } 
        int currentCombinations = 0;
        for(int i=0; i<nums.length; i++) {
            currentCombinations += helper(dp, sum+nums[i], target, nums);
        }
        return dp[sum]=currentCombinations;
    }
}