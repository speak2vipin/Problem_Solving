class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int N = nums.length;
        int rightMax[] = new int[N];
        rightMax[N-1] = nums[N-1];
        int suffixSum = nums[N-1];
        // Find max possible sum from right hand side
        
        for(int i=N-2; i>-1; i--) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i+1], suffixSum);
        }
        
        int maxSum = nums[0];
        // Special Sum would be sum with rotated elements
        int specialSum = Integer.MIN_VALUE;
        int prefixSum = 0;
        int curMax = 0;
   
        for(int i=0; i<N; i++) {
            // Simple Kadane algorithm
            if(curMax + nums[i]>0) {
                curMax = curMax + nums[i];
                maxSum = Math.max(maxSum, curMax);
            } else {
                curMax = 0;
            } 
            // Considering num[i] for being max
            maxSum = Math.max(maxSum, nums[i]);
            // Prefix Sum for calculating special sum i.e. rotated array sum
            prefixSum += nums[i];
            
            if(i<N-1) {
                specialSum = Math.max(specialSum, prefixSum + rightMax[i+1]);
            }
            
        }
        
        
        
        return Math.max(maxSum, specialSum);
    }
}