class Solution {
  
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
       
        int count = 1;
        long sum = 0l;
        int j = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            while(sum+k < (1l*nums[i] * (i-j+1))) {
                sum -= nums[j];
                j++;
            }
            count = Math.max(count, i-j+1);
        }
        return count;
            
        
    }
}