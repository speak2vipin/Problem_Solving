class Solution {
    public int jump(int[] nums) {
        int current =0;
        int farthest = 0;
        int n = nums.length;
        int jumps = 0;
        for(int i=0; i<nums.length; i++) {
            farthest = Math.max(farthest, nums[i]+i);
            if(current==i && i!=n-1) {
                jumps++;
                current = farthest;
            }
        }
        return jumps;
    }
}