class Solution {
    public int minOperations(int[] nums, int x) {
        int target = 0;
        int n = nums.length;
        for(int num : nums) {
            target += num;
        }
        target = target-x;
        
        int left = 0, right = 0;
        int tempTarget = 0;
        int len = Integer.MIN_VALUE;
       
        while(right<n) {
            tempTarget += nums[right];
            while(left<=right && tempTarget>target) {
                tempTarget -= nums[left];
                left++;
            }
            if(tempTarget==target) {
                len = Math.max(len, right-left+1);
            }
            right++;
        }
        return len==Integer.MIN_VALUE ? -1 : n-len;
    }
}