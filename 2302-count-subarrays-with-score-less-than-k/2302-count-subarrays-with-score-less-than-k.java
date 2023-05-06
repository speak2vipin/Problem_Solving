class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        int N = nums.length;
        int i=0;
        int j=0;
        long count = 0;
        long sum = 0;
        while(i<N) {
            sum += nums[i];
            while(sum * (i-j+1)>=k) {
                sum -= nums[j++];
            }
            count += i-j+1;
            i++;
        }
        return count;
    }
}