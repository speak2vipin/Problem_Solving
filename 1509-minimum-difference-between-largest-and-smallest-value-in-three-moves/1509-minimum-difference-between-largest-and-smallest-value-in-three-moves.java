class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length-1;
        if(n<3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int left=0, right=n-3; left<n+1 && right<n+1; left++, right++) {
            ans = Math.min(ans, nums[right] - nums[left]);
        }
        return ans;
    }
}