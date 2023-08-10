class Solution {
    public int search(int[] nums, int target) {
        int st = 0;
        int en = nums.length-1;
        while(st<=en) {
            int mid = en - (en-st)/2;
            if(nums[mid]==target) {
                return mid;
            }
            if(nums[mid]>=nums[st]) {
                if(target>=nums[st] && target<nums[mid]) {
                    en = mid-1;
                } else {
                    st = mid+1;
                }
            } else {
                if(target<=nums[en] && target>nums[mid]) {
                    st = mid+1;
                } else {
                    en = mid-1;
                }
            }
        }
        return -1;
    }
}