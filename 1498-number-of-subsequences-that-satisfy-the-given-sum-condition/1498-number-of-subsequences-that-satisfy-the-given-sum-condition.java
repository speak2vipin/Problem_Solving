class Solution {
    // Takeaway : 
        // Make an array power i.e. power[i] = (power[i-1] * 2) % mod;
        // Sort will give you correct count of subsequence;
    // Logic:
        // Subsequnece is a number or group of numbers from an array without deleting there order;
        // Two numbers can be in subsequence if there sum is <= target;
        // So ideally we can sort nums array and check teh subsequence;
        // Sort it and look for two pointers approach to look for valid subseqence;
    
    public int numSubseq(int[] nums, int target) {
        int mod = 1000_000_007;
        int N = nums.length;
        int power[] = new int[N];
        power[0] = 1;
        for(int i=1; i<N; i++) {
            power[i] = (power[i-1] * 2) % mod;
        }
        Arrays.sort(nums);
        int st = 0;
        int en = N-1;
        int ans = 0;
        while(st<=en) {
            if(nums[st] + nums[en] <= target) {
                ans = (ans + power[en-st])%mod;
                st++;
            } else {
                en--;
            }
        }
        return ans;
    }
}