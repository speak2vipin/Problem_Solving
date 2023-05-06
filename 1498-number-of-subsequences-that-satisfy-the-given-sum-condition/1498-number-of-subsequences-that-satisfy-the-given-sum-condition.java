class Solution {
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