class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n) {
            int correctId = nums[i]-1;
            if(nums[i]>0 && nums[i]<=n && nums[i] != nums[correctId]) {
                swap(nums, i, correctId);
            } else {
                i++;
            }
        }
        for(i=0; i<n; i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }
        return n+1;
    }
    
    void swap(int nums[], int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}