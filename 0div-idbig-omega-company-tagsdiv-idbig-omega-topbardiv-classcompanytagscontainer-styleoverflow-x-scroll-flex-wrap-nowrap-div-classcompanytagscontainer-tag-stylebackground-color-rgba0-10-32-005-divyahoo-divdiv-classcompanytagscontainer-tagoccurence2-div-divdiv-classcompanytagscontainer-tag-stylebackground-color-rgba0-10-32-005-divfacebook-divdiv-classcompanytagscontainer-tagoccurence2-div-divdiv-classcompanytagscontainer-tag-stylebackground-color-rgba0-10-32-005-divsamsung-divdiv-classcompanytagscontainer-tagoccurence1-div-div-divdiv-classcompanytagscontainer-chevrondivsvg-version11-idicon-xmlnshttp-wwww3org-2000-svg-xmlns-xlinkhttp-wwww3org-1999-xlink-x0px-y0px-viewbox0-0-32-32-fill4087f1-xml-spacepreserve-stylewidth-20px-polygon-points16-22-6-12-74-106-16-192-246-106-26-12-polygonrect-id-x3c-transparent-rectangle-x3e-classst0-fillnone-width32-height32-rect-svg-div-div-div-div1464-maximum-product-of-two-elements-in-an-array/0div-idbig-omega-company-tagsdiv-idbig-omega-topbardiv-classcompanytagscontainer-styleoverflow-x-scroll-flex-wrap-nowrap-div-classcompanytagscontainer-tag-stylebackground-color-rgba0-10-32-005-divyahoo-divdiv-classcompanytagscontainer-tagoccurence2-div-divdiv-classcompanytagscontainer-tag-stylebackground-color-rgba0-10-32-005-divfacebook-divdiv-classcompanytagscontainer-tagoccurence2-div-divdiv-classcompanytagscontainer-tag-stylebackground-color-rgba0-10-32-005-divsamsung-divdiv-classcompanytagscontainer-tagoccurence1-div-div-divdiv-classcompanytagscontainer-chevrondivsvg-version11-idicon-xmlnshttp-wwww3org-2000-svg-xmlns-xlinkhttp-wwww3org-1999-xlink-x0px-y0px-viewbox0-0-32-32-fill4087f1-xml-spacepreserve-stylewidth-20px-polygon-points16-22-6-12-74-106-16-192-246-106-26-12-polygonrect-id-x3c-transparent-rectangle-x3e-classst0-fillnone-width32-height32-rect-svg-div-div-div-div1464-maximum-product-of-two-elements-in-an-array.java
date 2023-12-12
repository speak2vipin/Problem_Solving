class Solution {
    public int maxProduct(int[] nums) {
        int firstTop = nums[0];
        int secondTop = 0;
        int n = nums.length;
        for(int i=1; i<n; i++) {
            if(firstTop<nums[i]) {
                secondTop = firstTop;
                firstTop = nums[i];
            } else if(secondTop<nums[i]) {
                secondTop = nums[i];
            }
        }
        return (firstTop-1) * (secondTop-1);
    }
}