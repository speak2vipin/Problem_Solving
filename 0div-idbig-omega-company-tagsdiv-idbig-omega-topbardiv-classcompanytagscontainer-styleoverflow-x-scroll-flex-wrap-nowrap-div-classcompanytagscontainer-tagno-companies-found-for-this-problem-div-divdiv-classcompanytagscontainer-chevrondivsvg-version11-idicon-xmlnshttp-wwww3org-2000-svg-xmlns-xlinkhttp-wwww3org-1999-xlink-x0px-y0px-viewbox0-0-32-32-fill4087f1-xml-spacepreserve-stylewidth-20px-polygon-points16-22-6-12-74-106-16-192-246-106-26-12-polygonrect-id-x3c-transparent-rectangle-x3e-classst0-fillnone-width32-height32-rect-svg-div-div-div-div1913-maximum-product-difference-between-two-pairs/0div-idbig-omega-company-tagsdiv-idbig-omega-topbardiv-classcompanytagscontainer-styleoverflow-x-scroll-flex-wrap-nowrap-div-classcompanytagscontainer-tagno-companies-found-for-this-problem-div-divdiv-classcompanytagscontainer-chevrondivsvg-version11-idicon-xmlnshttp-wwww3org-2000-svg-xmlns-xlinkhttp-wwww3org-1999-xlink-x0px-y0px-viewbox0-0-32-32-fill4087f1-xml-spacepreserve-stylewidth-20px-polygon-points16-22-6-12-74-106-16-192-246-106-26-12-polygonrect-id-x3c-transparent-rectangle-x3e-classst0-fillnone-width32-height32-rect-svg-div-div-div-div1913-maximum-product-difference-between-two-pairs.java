class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length-1;
        Arrays.sort(nums);
        return nums[n]*nums[n-1] - nums[1]*nums[0];
        
    }
}