class Solution {
    int left = -1;
    int right = -1;
    
    public int[] searchRange(int[] nums, int target) {
        if(nums!=null || nums.length!=0) {
            search(nums, target, 0, nums.length-1);
        }
        int ans[] = new int[2];
        ans[0] = left;
        ans[1] = right;
        return ans;
    }
    
    void search(int[] nums, int target, int low, int high) {
        int n = nums.length;
        while(low<=high) {
            int mid = high - (high-low)/2;
            if(nums[mid]==target && (mid==0 || nums[mid-1]!=target)) {
                left = mid;
            } else if(nums[mid]==target) {
                search(nums, target, low, mid-1);
            } 
            if(nums[mid]==target && (mid==n-1 ||nums[mid+1]!=target)){
                right = mid;
            } else if(nums[mid]==target) {
                search(nums, target, mid+1, high);
            }
            if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid +1;
            }
        }
    }
}