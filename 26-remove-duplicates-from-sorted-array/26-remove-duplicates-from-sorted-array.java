class Solution {
    public int removeDuplicates(int[] nums) {
        int expectedNums[] = new int[nums.length];
        int k=-101;
        int j = 0;
        for(int i=0; i<nums.length;i++) {
            if(nums[i]!=k) {
                expectedNums[j++] = nums[i];
                k = nums[i];
            } 
        }
        for (int x = 0; x < j; x++) {
            nums[x] = expectedNums[x];
        }
        return j;
    }
}