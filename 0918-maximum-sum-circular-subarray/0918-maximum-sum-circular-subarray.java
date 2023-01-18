class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int N = nums.length;
        int rightMax[] = new int[N];
        rightMax[N-1] = nums[N-1];
        int suffixSum = nums[N-1];
        for(int i=N-2; i>-1; i--) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i+1], suffixSum);
        }
        int prefix[] = new int[N];
        prefix[0] = nums[0];
        int maxSum = nums[0];
        int specialSum = Integer.MIN_VALUE;
        int prefixSum = 0;
        int curMax = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            if(curMax + nums[i]>0) {
                curMax = curMax + nums[i];
                maxSum = Math.max(maxSum, curMax);
            } else {
                curMax = 0;
            } 
            max = Math.max(max, nums[i]);
            maxSum = Math.max(maxSum, max);
            prefixSum += nums[i];
            if(i<N-2) {
                specialSum = Math.max(specialSum, prefixSum + rightMax[i+1]);
            }
            
        }
        
        
        
        return Math.max(maxSum, specialSum);
    }
}