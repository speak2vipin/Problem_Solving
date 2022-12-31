class Solution {
    public int maxSubArray(int[] nums) {
        // KADANE ALGORITHMS
        int N = nums.length;
        int max = nums[0];
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += nums[i];
            if(sum<=0) {
                sum = 0;
                max = Math.max(max, nums[i]);
            } else {
                max = Math.max(max, sum);
            } 
        }
        return max;
    }
}