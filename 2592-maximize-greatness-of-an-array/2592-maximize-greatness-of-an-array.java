class Solution {
    public int maximizeGreatness(int[] nums) {
        
		Arrays.sort(nums);
		int N = nums.length;
		int count = 0;
		int j=0;
        for(int num : nums) {
            if(nums[count]<num) {
                count++;
            }
        }
        return count;
    }
}