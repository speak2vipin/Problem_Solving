class Solution {
    int left = -1;
    int right = -1;
    
    public int[] searchRange(int[] nums, int target) {
        if(nums!=null || nums.length!=0) {
            left = searchLeft(nums, target); 
            right = searchRight(nums, target);
        }
        int ans[] = new int[2];
        ans[0] = left;
        ans[1] = right;
        return ans;
    }
    
    int searchLeft(int[] nums, int target) {
        int n = nums.length;
        int ans = -1;
        int low = 0;
        int high = n-1;
        while(low<=high) {
            int mid = high - (high-low)/2;
            if(nums[mid]==target && (mid==0 || nums[mid-1]!=target)) {
                ans = mid;
                break;
            }
            if(nums[mid]>=target) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return ans;
    }
    
    int searchRight(int[] nums, int target) {
        int n = nums.length;
        int ans = -1;
        int low = 0;
        int high = n-1;
        while(low<=high) {
            int mid = high - (high-low)/2;
            if(nums[mid]==target && (mid==n-1 || nums[mid+1]!=target)) {
                ans = mid;
                break;
            }
            if(nums[mid]<=target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}