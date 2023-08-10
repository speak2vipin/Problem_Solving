class Solution {
    public boolean search(int[] nums, int target) {
        int st = 0;
        int en = nums.length-1;
        while(st<=en) {
            int mid = en - (en-st)/2;
            if(nums[mid]==target) {
                return true;
            } 
            if(nums[st]==nums[mid] && nums[en]==nums[mid]) {
                st++;
                en--;
            } else if(nums[st]<=nums[mid]) {
                if(nums[st]<=target && target<nums[mid]) {
                    en = mid-1;
                } else {
                    st = mid+1;
                }
            } else {
                if(nums[mid]<target && nums[en]>=target) {
                    st = mid+1; 
                } else {
                    en = mid-1;
                }
            }
        }
        return false;
    }
}