class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long res = -1;
        long prev = 0;
        for(int i=0; i<nums.length; i++) {
            if(i>=2 && prev>nums[i]) {
                res = nums[i] + prev;
            }
            prev += nums[i];
        }
        return res;
    }
}