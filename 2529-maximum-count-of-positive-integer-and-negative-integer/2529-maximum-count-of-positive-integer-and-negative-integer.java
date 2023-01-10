class Solution {
    public int maximumCount(int[] nums) {
        int N = nums.length;
        if(nums[0]>0 || nums[N-1]<0) {
            return N;
        } else if(nums[0]==0 && nums[N-1]==0) {
            return 0;
        }
        int nindex = negative(nums, 0, N-1);
        int pindex = positive(nums, 0, N-1);
        return Math.max(nindex+1, N-1-(pindex-1));
    }
    
    int negative(int nums[], int st, int en) {
        int mid = (st+en)/2;
     
        if(st==en || (nums[mid]<0 && nums[mid+1]>=0)) {
            return mid;
        }
        if(nums[mid]>=0) {
            return negative(nums, st, mid-1);
        } else {
            return negative(nums, mid+1, en);
        }
    }
    
    int positive(int nums[], int st, int en) {
        
        int mid = (st+en)/2;
     
        if(st==en || (nums[mid]>0 && nums[mid-1]<=0)) {
            return mid;
        }
        if(nums[mid]>0) {
            return positive(nums, st, mid-1);
        } else {
            return positive(nums, mid+1, en);
        }
    
    }
}