class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = nums[0];
        for(int i=1;i<nums.length; i++) {
            ans = ans^nums[i];
        }
        return ans;
    }
    
    int binarySearch(int[]nums) {
        int st = 0;
        int en = nums.length-1;
        int ans = -1;
        while(st<en) {
            int mid = en - (en-st)/2;
            if(nums[mid]==nums[mid-1]) {
                en = mid-2;
            } else if(nums[mid]==nums[mid+1]) {
                st = mid+2;
            } else {
                ans = nums[mid];
                break;
            }
        }
        return ans;
        
    }
}