class Solution {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums);
    }
    
    int binarySearch(int[]nums) {
        int st = 0;
        int en = nums.length-1;
        int ans = -1;
        while(st<en) {
            int mid = en - (en-st)/2;
            if(mid%2 == 1) {
                mid--;
            } 
            if(nums[mid]==nums[mid+1]) {
                st = mid+2;
            } else {
                en = mid;
            }
        }
        return nums[st];
        
    }
}