class Solution {
    public int splitArray(int[] nums, int k) {
        int ans = -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        long l = max;
        long r = sum;
        while(l<=r) {
            long mid = (r+l)/2;
            boolean isPossible = isValid(nums, mid, k);
           // boolean oneLessIsPossible = isValid(nums, mid-1, k);
            //if(isPossible && !oneLessIsPossible) {
              //  ans = (int)mid;
            //}
            if(isPossible) {
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return (int)l;
    }
    
    boolean isValid(int nums[], long mid, int k) {
        int sum = 0;
        int count = 1;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum>mid) {
                count++;
                sum = nums[i];
            }
            if(count>k) {
                return false;
            }
        }
        return true;
    }
    
}