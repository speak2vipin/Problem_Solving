class Solution {
    public int searchInsert(int[] nums, int target) {
        int st = 0;
        int en = nums.length-1;
        int mid = st;
        while(st<=en) {
            mid = en - (en-st)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid]>target) {
                en = mid-1;
            } else{
                st = mid+1;
            }
        }
       // if(nums[mid]<target) {
         //   mid = mid+1;
        //}
        return st;
    }
}