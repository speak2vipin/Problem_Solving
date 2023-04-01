class Solution {
    public int search(int[] nums, int target) {
        int st = 0;
        int en = nums.length-1;
        int mid = 0;
        while(st<=en) {
            mid = st + (en-st)/2;
            if(nums[mid]==target) {
                return mid;
            }
            if(nums[mid]<target) {
                st = mid+1;
            } else {
                en = mid-1;
            }
        }
        return -1;
        
    }
}