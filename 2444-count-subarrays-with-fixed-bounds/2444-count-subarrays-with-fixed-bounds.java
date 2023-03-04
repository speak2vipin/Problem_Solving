class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int N = nums.length;
        long ans = 0;
        long leftBound = -1;
        long minNum = -1;
        long maxNum = -1;
        for(int i=0; i<N; i++) {
            if(nums[i]>maxK || nums[i]<minK) {
                leftBound = i;
            }
            if(nums[i]==minK) {
                minNum = i;
            }
            if(nums[i]==maxK) {
                maxNum = i;
            }
            ans = ans + Math.max(0, Math.min(minNum, maxNum)-leftBound);
        }
        return ans; 
    }
}