class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // https://leetcode.com/problems/arithmetic-slices-ii-subsequence/discuss/92822/Detailed-explanation-for-Java-O(n2)-solution
        int n = nums.length;
        Map<Long, Integer>[] dp = new Map[n];
        int res = 0;
        for(int i=0; i<n; i++) {
            dp[i] = new HashMap<>();
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                long diff = (long)nums[i]-nums[j];
            
                int c1 = dp[i].getOrDefault(diff, 0);
                int c2 = dp[j].getOrDefault(diff, 0);
                res += c2;
                // Total pair
                //     (6,8)
                //   (4,6,8)
                // (2,4,6,8)
                // New 10
                //     8,10
                //   6,8,10
                // 4,6,8,10
               //2,4,6,8,10
                // Total dp[10][2] = dp[8][2] + 1 (Extra 8,10)
                // Remember it require subsequence of length 3 or more so
                // Ans += dp[8][2]
                dp[i].put(diff, c1+c2+1);
            }
        }
        return res;
    }
}