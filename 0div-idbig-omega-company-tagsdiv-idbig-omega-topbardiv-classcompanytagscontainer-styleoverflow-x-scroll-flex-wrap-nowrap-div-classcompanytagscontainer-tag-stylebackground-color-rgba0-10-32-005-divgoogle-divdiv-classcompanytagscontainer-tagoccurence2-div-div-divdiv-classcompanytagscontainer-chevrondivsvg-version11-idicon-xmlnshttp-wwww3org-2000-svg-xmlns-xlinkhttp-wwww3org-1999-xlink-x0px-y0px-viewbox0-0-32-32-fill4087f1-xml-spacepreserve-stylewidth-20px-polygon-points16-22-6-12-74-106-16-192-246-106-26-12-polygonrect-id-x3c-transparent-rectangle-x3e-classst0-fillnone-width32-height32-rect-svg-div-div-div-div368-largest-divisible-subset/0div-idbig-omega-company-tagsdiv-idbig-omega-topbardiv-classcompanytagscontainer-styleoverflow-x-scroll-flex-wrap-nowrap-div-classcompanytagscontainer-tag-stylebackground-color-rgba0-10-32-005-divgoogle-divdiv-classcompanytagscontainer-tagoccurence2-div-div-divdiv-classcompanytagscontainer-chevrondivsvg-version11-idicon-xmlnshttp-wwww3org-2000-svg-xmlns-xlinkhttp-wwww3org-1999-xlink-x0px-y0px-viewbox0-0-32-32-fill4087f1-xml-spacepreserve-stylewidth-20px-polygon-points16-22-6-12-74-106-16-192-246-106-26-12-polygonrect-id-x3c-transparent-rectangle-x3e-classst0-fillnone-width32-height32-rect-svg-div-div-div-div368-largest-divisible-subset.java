class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i]%nums[j]==0) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        int prev = -1;
        List<Integer> res = new ArrayList<Integer>();
        for(int i=n-1; i>-1; i--) {
            if(dp[i]==max && (prev==-1 || (prev%nums[i]==0))) {
                res.add(nums[i]);
                max--;
                prev = nums[i];
            }
        }
        return res;
    }
}