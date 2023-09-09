class Solution {
    //Integer dp[] = null;
    
    /*public int combinationSum4(int[] nums, int target) {
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
    
    public int combinationSum4(int[] nums, int target) {
        Integer dp[] = new Integer[target + 1];
        
        helper(dp, target, target, nums);
		return dp[target]==null?0:dp[target];
	}
    
    int helper(Integer dp[], int sum, int target, int nums[]) {
        if(sum<0) {
            return 0;
        } else if(sum==0) {
            return 1;
        }
        if(dp[sum]!=null) {
            return dp[sum];
        }
        int currentCombinations = 0;
        for(int i=0; i<nums.length; i++) {
            currentCombinations += helper(dp, sum-nums[i], target, nums);
        }
        return dp[sum] = currentCombinations;
    }
    */
    
     public int combinationSum4(int[] nums, int target) {
        long dp[] = new long[target + 1];
        helper(dp, target, nums);
		return (int)dp[target];
	}
    
    void helper(long dp[], int target, int nums[]) {
        dp[0] = 1;
        for(int currentSum=1; currentSum<=target; currentSum++) {
            for(int i=0;i<nums.length; i++) {
                if(currentSum-nums[i]>=0) {
                    dp[currentSum] += dp[currentSum-nums[i]];
                }
            }
        }
    }
}