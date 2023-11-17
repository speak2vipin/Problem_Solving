class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = n-1;
        int ans = Integer.MIN_VALUE;
        while(i<j) {
            ans = Math.max(ans, nums[i]+nums[j]);
            i++;
            j--;
        }
        return ans;
    }
}