class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Bruteforce
        /*for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum += nums[j];
                if(sum==goal){
                    count++;
                }
            }
        }*/
        return 
        slidingWindowWithAtMostSum(nums, goal) - slidingWindowWithAtMostSum(nums, goal-1);
    }
    
    int slidingWindowWithAtMostSum(int nums[], int goal) {
        int end = 0;
        int start = 0;
        int sum = 0;
        int count = 0;
        while(end<nums.length) {
            sum += nums[end];
            while(start<=end && sum>goal) {
                sum -= nums[start++];
            }
            count += end-start+1;
            end++;
        }
        return count;
    }
}