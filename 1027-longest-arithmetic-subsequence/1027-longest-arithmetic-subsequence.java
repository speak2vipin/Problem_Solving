class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> dp[] = new HashMap [n];
        int maxLen = Integer.MIN_VALUE;
        for(int right=0; right<n; right++) {
            HashMap<Integer, Integer> indexMap = new HashMap<>();
			dp[right] = indexMap;
            for(int left=0; left<right; left++) {
                int diff = nums[right] - nums[left];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);
                maxLen = Math.max(maxLen, dp[right].get(diff));
            }
        }
        return maxLen;
    }
}