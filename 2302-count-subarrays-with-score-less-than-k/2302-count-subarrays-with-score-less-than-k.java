class Solution {
    // Takeaway : Logic is to consider Subarray formed with the last indexed element
    // Logic:
        // Maintain a sliding window which maintain the condition i.e. sum*len<k
            // If condition is breaking then shrink your window i.e. j++
        // count the sub array formed with last elements
        // return count.
    
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