class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = Math.max(max, num);
        }
        long count = 0;
        int i = 0, j = 0;
        int n = nums.length;
        int maxFreq = 0;
        while(i<n) {
            if(nums[i]==max) {
                maxFreq++;
            }
            while(maxFreq==k) {
                if(nums[j]==max) {
                    maxFreq--;
                }
                j++;
            }
            count += j;
            i++;
        }
        return count;
    }
}