class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int resCount = -1;
        int n = nums.length;
        long sum = 0;
        int i = 0;
        
        for(int j=0; j<n; j++) {
            sum += nums[j];
            while(sum + k < (1l * nums[j] * (j-i+1))) {
                sum -= nums[i];
                i++;
            }
            resCount = Math.max(resCount, j-i+1);
        }
        return resCount;
    }
}